package first;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        UserAuthentication user = new UserAuthentication();
        ShoppingCart cart = null;

        while (!loggedIn) {
            System.out.println("Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Log in");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    user.register();
                    break;
                case 2:
                    if (user.login()) {
                        cart = new ShoppingCart(user);
                        loggedIn = true;
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. View shop");
            System.out.println("2. Add to cart");
            System.out.println("3. View cart");
            System.out.println("4. Checkout");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    cart.viewShop();
                    break;
                case 2:
                    cart.addToCart();
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    cart.checkout();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

}
