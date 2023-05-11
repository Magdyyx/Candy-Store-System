
public class OrderItem {
    private item item;
    private int quantity;

    public OrderItem(item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public item getItem() {
        return item;
    }

    public void setItem(item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
