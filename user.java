import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;
    private String address;
    private int loyaltyPoints;
    private List<GiftVoucher> giftVouchers;
    private List<order> orders;
    private List<OrderItem> cart;
    private LoyaltyPointsScheme loyaltyPointsScheme;
    private boolean accountStatus;
    private String otp;
    private static int id;

    public User(String email, String password, String address) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.loyaltyPoints = 0;
        this.giftVouchers = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.cart = new ArrayList<>();
        this.accountStatus = false;
    }
    public User(int id, String email, String password, String address, String otp) {
        User.id = id;
        this.email = email;
        this.password = password;
        this.address = address;
        this.otp = otp;
    }
    

    public LoyaltyPointsScheme getLoyaltyPointsScheme() {
        return loyaltyPointsScheme;
    }

    public void setLoyaltyPointsScheme(LoyaltyPointsScheme loyaltyPointsScheme) {
        this.loyaltyPointsScheme = loyaltyPointsScheme;
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

    public List<order> getOrders() {
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

    public void decreaseLoyaltyPoints(int points) {
        this.loyaltyPoints -= points;
    }

    public void addGiftVoucher(GiftVoucher giftVoucher) {
        this.giftVouchers.add(giftVoucher);
    }

    public void addOrder(order order) {
        this.orders.add(order);
    }

    public void addItemToCart(OrderItem cartItem) {
        this.cart.add(cartItem);
    }

    public void removeItemFromCart(OrderItem cartItem) {
        this.cart.remove(cartItem);
    }

    public void setLoyaltyPoints(int points) {
        setLoyaltyPoints(points);
    }
    public static int getId() {
        return id;
    }
    public String getOtp() {
        return otp;
    }
    public void setPassword(String password2) {
        this.password = password2;
    
    }
    public void suspend() {
        this.accountStatus = false;
    
    }
    
}
