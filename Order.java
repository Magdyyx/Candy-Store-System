import java.util.ArrayList;
import java.util.List;

public class order {
    private int orderId;
    private User user;
    private int userId;
    private List<OrderItem> orderItems;
    private String shippingAddress;
    private PaymentMethod paymentMethod;
    private String orderStatus;
    private String paymentStatus;
    private float totalAmount;
    private List<GiftVoucher> appliedVouchers;

    public order(int orderId, int userId, List<OrderItem> orderItems, String shippingAddress,
            PaymentMethod paymentMethod, String orderStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderItems = orderItems;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
        this.appliedVouchers = new ArrayList<>();
    }

    public order(List<Item> cartItems, String shippingAddress2, PaymentMethod paymentMethod2, float totalPrice) {
        // Create an OrderItem for each item in the cart
        List<OrderItem> orderItems = new ArrayList<>();
        for (Item item : cartItems) {
            OrderItem orderItem = new OrderItem(item, 1);
            orderItems.add(orderItem);
        }
    
        // Set the properties of the order
        this.orderId = generateOrderId();
        this.userId = User.getId();
        this.orderItems = orderItems;
        this.shippingAddress = shippingAddress2;
        this.paymentMethod = paymentMethod2;
        this.orderStatus = "Placed";
        this.paymentStatus = "Pending";
        this.totalAmount = totalPrice;
        this.appliedVouchers = new ArrayList<>();
    }
    
    private int generateOrderId() {
        // Generate a random integer between 100000 and 999999
        return (int) (Math.random() * (999999 - 100000 + 1) + 100000);
    }
    
    

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public List<GiftVoucher> getAppliedVouchers() {
        return appliedVouchers;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setTotal(float total) {
        this.totalAmount = total;
    }

    public float getTotalAmount() {
        float totalAmount = 0.0f;

        for (OrderItem item : orderItems) {
            totalAmount += item.getItem().getPrice() * item.getQuantity();
        }

        return totalAmount;
    }

    public User getUser() {
        return user;
    }

}