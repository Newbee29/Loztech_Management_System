import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer extends User {
    private String phoneNumber;

    private ShoppingCart[] shoppingCartHistory = new ShoppingCart[10];
    private int historyCount = 0;
    private Report report;

    private ShoppingCart cart;
    private Item sharedItem;
    private Menu menu;
    private Scanner sc = new Scanner(System.in);

    public Customer(Item item) {
        this.sharedItem = item;
        this.menu = new Menu(sharedItem);      // Menu connected to shared items
        this.cart = new ShoppingCart(sharedItem);
        this.report = new Report();
    }

    public void viewCustomer() {
        while (true) {
            System.out.println("\n=== CUSTOMER MENU ===");
            System.out.println("1. Add Item to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout / Make Payment");
            System.out.println("4. View Purchase History");
            System.out.println("5. Track Order");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice: ");

            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();

            switch (choice) {
                case 1:
                    cart.addCartItem(menu);   // Add items from menu to cart
                    break;
                case 2:
                    cart.viewCart();
                    break;
                case 3:
                    if (!cart.isEmpty()) {   // Proceed if cart has items
                        Payment payment = new Payment(cart.getTotalAmount());
                        payment.makePayment(sc);
                        payment.getReceipt(cart);
                        cart.reduceStock();
                        report.addOrder(cart, payment);

                        if (historyCount < 10) {
                            shoppingCartHistory[historyCount++] = cart;
                        }
                        cart = new ShoppingCart(sharedItem);  // create new cart for next order
                    } else {
                        System.out.println("Cart is empty! Cannot checkout.");
                    }
                    break;
                case 4:
                    viewPurchaseHistory();
                    break;
                case 5:
                    trackOrders();
                    break;
                case 6:
                    System.out.println("Exiting customer menu...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public void viewPurchaseHistory() {
        if (historyCount == 0) {
            System.out.println("No Purchase History Yet.");
            return;
        }
        System.out.println("\n===== Purchase History =====");
        for (int i = 0; i < historyCount; i++) {
            System.out.println("Cart " + (i + 1) + " (Cart Code: " + shoppingCartHistory[i].getCartCode() + "):");
            shoppingCartHistory[i].viewCart();
            System.out.println("Total Amount: RM" + shoppingCartHistory[i].getTotalAmount());
        }
    }

    public void trackOrders() {
        if (historyCount == 0) {
            System.out.println("You have no orders to track.");
            return;
        }
        ShoppingCart lastOrder = shoppingCartHistory[historyCount - 1];
        System.out.println("\nTracking Latest Order:");
        lastOrder.showOrderStatus();
        lastOrder.advanceOrderStatus();
    }
}
