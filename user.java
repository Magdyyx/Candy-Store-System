import java.util.ArrayList;
import java.util.List;

public class user {
    private String email;
    private String password;
    private String address;
    private int loyaltyPoints;
    private List<GiftVoucher> giftVouchers;
    private List<Order> orders;
    private List<OrderItem> cart;
    private boolean accountStatus;

    public user(String email, String password, String address) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.loyaltyPoints = 0;
        this.giftVouchers = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.accountStatus = false;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public List<GiftVoucher> getGiftVouchers() {
        return giftVouchers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<OrderItem> getCart() {
        return cart;
    }

    public boolean getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    public void addGiftVoucher(GiftVoucher giftVoucher) {
        this.giftVouchers.add(giftVoucher);
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void addItemToCart(OrderItem cartItem) {
        this.cart.add(cartItem);
    }

    public void removeItemFromCart(OrderItem cartItem) {
        this.cart.remove(cartItem);
    }
}
