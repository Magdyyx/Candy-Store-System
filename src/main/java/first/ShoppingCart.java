package first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {

    private UserAuthentication user;
    private Map<String, Item> shop;
    private List<Item> cart;

    public ShoppingCart(UserAuthentication user) {
        this.user = user;
        this.shop = new HashMap<>();
        this.cart = new ArrayList<>();
        initializeShop();
    }

    private void initializeShop() {
        // Populate the shop with some sample items
        shop.put("cake", new Item("cake", 0.5));
        shop.put("chocoalte", new Item("chocoalte", 0.3));
        shop.put("candy", new Item("candy", 0.4));
        shop.put("mango", new Item("mango", 1.0));
    }

    public void viewShop() {
        System.out.println("Shop items:");
        for (Item item : shop.values()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }

    public void addToCart() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter item name:");
        String itemName = scanner.nextLine().toLowerCase();

        Item item = shop.get(itemName);
        if (item == null) {
            System.out.println("Item not found in shop.");
        } else {
            cart.add(item);
            System.out.println(item.getName() + " added to cart.");
        }
    }

    public void viewCart() {
        System.out.println("Cart items:");
        double total = 0.0;
        for (Item item : cart) {
            System.out.println(item.getName() + " - $" + item.getPrice());
            total += item.getPrice();
        }
        System.out.println("Total: $" + total);
    }

    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("Checking out...");
        double total = 0.0;
        for (Item item : cart) {
            total += item.getPrice();
        }

        System.out.println("Total amount due: $" + total);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter payment method (1 for Cash, 2 for Credit Card):");
        int paymentMethod = scanner.nextInt();

        if (paymentMethod == 1) {
            System.out.println("Enter amount paid:");
            double amountPaid = scanner.nextDouble();

            if (amountPaid < total) {
                System.out.println("Insufficient payment.");
                return;
            }

            double change = amountPaid - total;
            System.out.println("Change: $" + change);

            System.out.println("Thank you for your purchase!");

        } else if (paymentMethod == 2) {
            System.out.println("Enter credit card number:");
            String cardNumber = scanner.nextLine();

            System.out.println("Enter expiration date (MM/YY):");
            String expirationDate = scanner.nextLine();

            System.out.println("Enter CVV:");
            String cvv = scanner.nextLine();

            System.out.println("Processing payment...");

            System.out.println("Payment processed successfully!");
            System.out.println("Thank you for your purchase!");
        } else {
            System.out.println("Invalid payment method.");
            return;
        }

        // Clear the cart after successful checkout
        cart.clear();
    }

}
