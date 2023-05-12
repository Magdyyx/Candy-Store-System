import java.util.List;

public class AdminController {
    private Catalog catalog;
    private List<order> orders;
    private LoyaltyPointsScheme loyaltyPointsScheme;

    public AdminController(Catalog catalog, List<order> orders, LoyaltyPointsScheme loyaltyPointsScheme) {
        this.catalog = catalog;
        this.orders = orders;
        this.loyaltyPointsScheme = loyaltyPointsScheme;
    }

    public void add_item(Item item) {
        catalog.addItem(item);
    }

    public void remove_item(Item item) {
        catalog.remove_item(item);
    }

    public void update_item_info(Item item) {
        catalog.updateItemInfo(item);
    }

    public void cancel_item(Item item) {
        catalog.cancel_item(item);
    }

    public void set_loyalty_points_scheme(LoyaltyPointsScheme loyaltyPointsScheme) {
        this.loyaltyPointsScheme = loyaltyPointsScheme;
    }

    public void suspend_user(User user) {
        user.suspend();
    }

    public List<order> get_orders() {
        return orders;
    }

    public void view_statistics() {

    }
}
