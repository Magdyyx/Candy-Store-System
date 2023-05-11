import java.util.List;

public class AdminController {
    private catalog catalog;
    private List<Order> orders;
    private LoyaltyPointsScheme loyaltyPointsScheme;

    public AdminController(catalog catalog, List<Order> orders, LoyaltyPointsScheme loyaltyPointsScheme) {
        this.catalog = catalog;
        this.orders = orders;
        this.loyaltyPointsScheme = loyaltyPointsScheme;
    }

    public void add_item(item item) {
        catalog.add_item(item);
    }

    public void remove_item(item item) {
        catalog.remove_item(item);
    }

    public void update_item_info(item item) {
        catalog.update_item_info(item);
    }

    public void cancel_item(item item) {
        catalog.cancel_item(item);
    }

    public void set_loyalty_points_scheme(LoyaltyPointsScheme loyaltyPointsScheme) {
        this.loyaltyPointsScheme = loyaltyPointsScheme;
    }

    public void suspend_user(user user) {
        user.suspend();
    }

    public List<Order> get_orders() {
        return orders;
    }

    public void view_statistics() {
        // TODO: implement statistics view
    }
}
