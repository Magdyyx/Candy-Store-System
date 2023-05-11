import java.util.*;

public class Database {
    private List<user> users;
    private catalog catalog;
    private List<Order> orders;
    private List<GiftVoucher> vouchers;
    
    public Database() {
        users = new ArrayList<user>();
        catalog = new catalog();
        orders = new ArrayList<Order>();
        vouchers = new ArrayList<GiftVoucher>();
    }
    
    public void addUser(user user) {
        users.add(user);
    }
    
    public void removeUser(user user) {
        users.remove(user);
    }
    
    public List<user> getUsers() {
        return users;
    }
    
    public catalog getCatalog() {
        return catalog;
    }
    
    public void addOrder(Order order) {
        orders.add(order);
    }
    
    public List<Order> getOrders() {
        return orders;
    }
    
    public void addVoucher(GiftVoucher voucher) {
        vouchers.add(voucher);
    }
    
    public List<GiftVoucher> getVouchers() {
        return vouchers;
    }
}
