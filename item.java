import java.util.ArrayList;
import java.util.List;

public class Item {
    private int id;
    private String name;
    private Category category;
    private String description;
    private String image;
    private String brand;
    private float price;
    private float discountPercentage;
    private float quantity;

    public Item(int id, String name, Category category, String description, String image, String brand, float price,
            float discountPercentage) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.image = image;
        this.brand = brand;
        this.price = price;
        this.discountPercentage = discountPercentage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getBrand() {
        return brand;
    }

    public float getPrice() {
        return price;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public void setBrand(String brand2) {
        this.brand = brand2;
    }

    public void setCategory(Category category2) {
        this.category = category2;
    }

    public void setPrice(float price2) {
        this.price = price2;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public void setDiscountPercentage(float discountPercentage2) {
        this.discountPercentage = discountPercentage2;
    }

    public Item getItem() {
        return this;
        
    }
}
