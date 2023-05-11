import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Item> items;
    private List<Category> categories;
    private int loyaltyPointsScheme;
    private float loyaltyPointsDiscount;

    public Catalog() {
        this.items = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public List<Item> searchItems(String name, String brand) {
        List<Item> searchResults = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(name) && item.getBrand().equals(brand)) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }

    public List<Item> filterItems(String category) {
        List<Item> filteredItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getCategory().getName().equals(category)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    public void setLoyaltyPointsScheme(int points) {
        setLoyaltyPointsScheme(points);
    }

    public int getLoyaltyPointsScheme() {
        return loyaltyPointsScheme;
    }

    public float getLoyaltyPointsDiscount() {
        return loyaltyPointsDiscount;
    }
}
