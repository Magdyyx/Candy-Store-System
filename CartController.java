import java.util.*;

public class CartController {
    private static Map<Integer, List<OrderItem>> userCarts;

    public CartController() {
        userCarts = new HashMap<>();
    }

    public int getId(Item item) {
        // Iterate over user carts to find the item and return its ID
        for (List<OrderItem> cart : userCarts.values()) {
            for (OrderItem cartItem : cart) {
                if (cartItem.getItem().equals(item)) {
                    return cartItem.getItem().getId();
                }
            }
        }
        throw new IllegalArgumentException("Item not found in any user cart");
    }

    public void addCartItem(int userId, Item item, int quantity) {
        if (quantity < 1 || quantity > 50) {
            throw new IllegalArgumentException("Invalid quantity: " + quantity);
        }
        List<OrderItem> cart = userCarts.getOrDefault(userId, new ArrayList<>());
        for (OrderItem cartItem : cart) {
            if (cartItem.getItem().getId() == item.getId()) {
                int newQuantity = cartItem.getQuantity() + quantity;
                if (newQuantity > 50) {
                    throw new IllegalArgumentException("Exceeds max quantity for item: " + item.getName());
                }
                cartItem.setQuantity(newQuantity);
                return;
            }
        }
        cart.add(new OrderItem(item, quantity));
        userCarts.put(userId, cart);
    }

    public void removeCartItem(int userId, int itemId) {
        List<OrderItem> cart = userCarts.getOrDefault(userId, new ArrayList<>());
        cart.removeIf(cartItem -> cartItem.getItem().getId() == itemId);
        userCarts.put(userId, cart);
    }

    public void updateCartItemQuantity(int userId, int itemId, int newQuantity) {
        if (newQuantity < 1 || newQuantity > 50) {
            throw new IllegalArgumentException("Invalid quantity: " + newQuantity);
        }
        List<OrderItem> cart = userCarts.getOrDefault(userId, new ArrayList<>());
        for (OrderItem cartItem : cart) {
            if (cartItem.getItem().getId() == itemId) {
                cartItem.setQuantity(newQuantity);
                return;
            }
        }
        throw new IllegalArgumentException("Cart item not found: " + itemId);
    }

    public void clearCart(int userId) {
        userCarts.remove(userId);
    }

    public List<OrderItem> getUserCart(int userId) {
        return userCarts.getOrDefault(userId, new ArrayList<>());
    }
    public static List<Item> getCartItems(int id) {
        List<Item> items = new ArrayList<>();
        List<OrderItem> cart = userCarts.get(id);
        if (cart == null) {
            return items;
        }
        for (OrderItem cartItem : cart) {
            items.add(cartItem.getItem());
        }
        return items;
    }

    public static float calculateCartTotal(List<Item> itemsInCart) {
        float total = 0;
        for (Item item : itemsInCart) {
            total += item.getPrice();
        }
        return total;
        
    }
   
}