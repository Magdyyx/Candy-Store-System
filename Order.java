import java.util.List;

public class Order {
    private int orderId;
    private int userId;
    private List<OrderItem> orderItems;
    private String shippingAddress;
    private PaymentMethod paymentMethod;
    private String orderStatus;

    public Order(int orderId, int userId, List<OrderItem> orderItems, String shippingAddress,
             PaymentMethod paymentMethod, String orderStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderItems = orderItems;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.orderStatus = orderStatus;
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

    public float getTotalAmount() {
        float totalAmount = 0.0f;
    
        for (OrderItem item : orderItems) {
            totalAmount += item.getItem().getPrice() * item.getQuantity();
        }
    
        return totalAmount;
    }
}