import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Item> items;
    private List<Category> categories;
    private int loyaltyPointsScheme;
    private float loyaltyPointsDiscount;
    private List<GiftVoucher> giftVouchers;

    public Catalog() {
        this.items = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.giftVouchers = new ArrayList<>();
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

    public void remove_item(Item item) {
        items.remove(item);
    }

    public void updateItemInfo(Item item) {
        for (int i = 0; i < items.size(); i++) {
            Item currentItem = items.get(i);
            if (currentItem.getId() == item.getId()) {
                // Update the item's information
                currentItem.setName(item.getName());
                currentItem.setBrand(item.getBrand());
                currentItem.setCategory(item.getCategory());
                currentItem.setPrice(item.getPrice());
                currentItem.setQuantity(item.getQuantity());
                break;
            }
        }
    }

    public void cancel_item(Item item) {
        for (int i = 0; i < items.size(); i++) {
            Item currentItem = items.get(i);
            if (currentItem.getId() == item.getId()) {
                // Update the item's information
                currentItem.setQuantity(0);
                break;
            }
        }
    }

    public void addGiftVoucher(GiftVoucher voucher) {
        this.giftVouchers.add(voucher);
    }

    public GiftVoucher getGiftVoucherByCode(String voucherCode) {
        for (GiftVoucher voucher : giftVouchers) {
            if (voucher.getCode().equals(voucherCode)) {
                return voucher;
            }
        }
        return null;
    }
}
