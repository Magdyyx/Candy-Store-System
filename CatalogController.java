import java.util.List;

public class CatalogController {
    private Catalog catalog;
    private order order;

    public CatalogController(Catalog catalog, order order) {
        this.catalog = catalog;
        this.order = order;
    }

    public List<Item> getItems() {
        return catalog.getItems();
    }

    public List<Category> getCategories() {
        return catalog.getCategories();
    }

    public List<Item> searchItems(String name, String brand) {
        return catalog.searchItems(name, brand);
    }

    public List<Item> filterItems(String category) {
        return catalog.filterItems(category);
    }
}
