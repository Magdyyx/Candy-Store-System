import java.util.List;

public class CatalogController {
    private catalog catalog;

    public CatalogController(catalog catalog) {
        this.catalog = catalog;
    }

    public List<item> getItems() {
        return catalog.getItems();
    }

    public List<Category> getCategories() {
        return catalog.getCategories();
    }

    public List<item> searchItems(String name, String brand) {
        return catalog.searchItems(name, brand);
    }

    public List<item> filterItems(String category) {
        return catalog.filterItems(category);
    }
}
