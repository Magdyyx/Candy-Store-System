import java.util.ArrayList;
import java.util.List;

public class catalog {
    private List<item> items;
    private List<Category> categories;

    public catalog() {
        this.items = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public List<item> getItems() {
        return items;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addItem(item item) {
        this.items.add(item);
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }
}
