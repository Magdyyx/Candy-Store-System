import java.util.List;

public class OrderController {
    private CatalogController catalogController;
    private CartController cartController;
    private AuthenticationController authController;
    private Database database;

    public OrderController(CatalogController catalogController, CartController cartController,
                           AuthenticationController authController, Database database) {
        this.catalogController = catalogController;
        this.cartController = cartController;
        this.authController = authController;
        this.database = database;
    }

    public Order placeOrder(int userId, String shippingAddress, PaymentMethod paymentMethod) throws Exception {
        // Check if the user is logged in and has items in their cart
        if (!authController.isUserLoggedIn(userId)) {
            throw new Exception("User is not logged in");
        }
        List<OrderItem> cartItems = cartController.getCartItems(userId);
        if (cartItems.isEmpty()) {
            throw new Exception("Cart is empty");
        }

        // Check if the shipping address is valid
        if (shippingAddress == null || shippingAddress.isEmpty()) {
            throw new Exception("Invalid shipping address");
        }

        // Calculate the total price of the order
        float totalPrice = 0;
        for (OrderItem item : cartItems) {
            totalPrice += item.getItem().getPrice() * item.getQuantity();
        }

        // Check if the user has enough loyalty points to place the order
        user user = authController.getUserById(userId);
        int loyaltyPoints = user.getLoyaltyPoints();
        if (loyaltyPoints > 0) {
            int loyaltyPointsToUse = Math.min(loyaltyPoints, (int) totalPrice);
            totalPrice -= loyaltyPointsToUse;
            authController.updateLoyaltyPoints(userId, loyaltyPoints - loyaltyPointsToUse);
        }

        // Check if the user has any gift vouchers to use
        List<GiftVoucher> giftVouchers = user.getGiftVouchers();
        for (GiftVoucher voucher : giftVouchers) {
            if (!voucher.isRedeemed() && voucher.getValue() <= totalPrice) {
                totalPrice -= voucher.getValue();
                voucher.setRedeemed(true);
            }
        }

        // Create the order
        Order order = new Order(cartItems, shippingAddress, paymentMethod, totalPrice);
        database.addOrder(order);

        // Clear the user's cart
        cartController.clearCart(userId);

        return order;
    }

    public void cancelOrder(int userId, int orderId) throws Exception {
        // Check if the user is logged in and is the owner of the order
        if (!authController.isUserLoggedIn(userId)) {
            throw new Exception("User is not logged in");
        }
        Order order = database.getOrderById(orderId);
        if (order == null || order.getUser().getId() != userId) {
            throw new Exception("Order not found");
        }

        // Cancel the order
        order.setStatus(OrderStatus.CANCELLED);
        database.updateOrder(order);
    }

    public List<Order> getOrderHistory(int userId) throws Exception {
        // Check if the user is logged in
        if (!authController.isUserLoggedIn(userId)) {
            throw new Exception("User is not logged in");
        }

        // Get the user's order history
        return database.getOrdersByUserId(userId);
    }
}
