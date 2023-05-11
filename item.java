import java.util.List;


public class item {
    private String name;
    private Category category;
    private String description;
    private String image;
    private String brand;
    private float price;
    private float discountPercentage;

    public item(String name, Category category, String description, String image, String brand, float price, float discountPercentage) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.image = image;
        this.brand = brand;
        this.price = price;
        this.discountPercentage = discountPercentage;
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
}
