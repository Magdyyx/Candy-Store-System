import java.util.*;

public class Database {
    private List<User> users;
    private Catalog catalog;
    private List<order> orders;
    private List<GiftVoucher> vouchers;

    public Database() {
        users = new ArrayList<User>();
        catalog = new Catalog();
        orders = new ArrayList<order>();
        vouchers = new ArrayList<GiftVoucher>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void addOrder(order order) {
        orders.add(order);
    }

    public List<order> getOrders() {
        return orders;
    }

    public void addVoucher(GiftVoucher voucher) {
        vouchers.add(voucher);
    }

    public List<GiftVoucher> getVouchers() {
        return vouchers;
    }
}
