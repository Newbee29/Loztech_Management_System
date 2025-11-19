/*import java.util.*;
public class Customer {


    public class Customer extends User {
        private String phoneNumber;
        private ShoppingCart cart;
        private ShoppingCart[] shoppingCartHistory = new ShoppingCart[10];
        private int historyCount = 0;
        private Report report;
        private Payment payment;

        public Customer(String name, String pass, String pN) {
            super(name, pass);
            this.phoneNumber = pN;
            this.cart = new ShoppingCart();
            this.report=new Report();
        }

        public void viewCustomer(Scanner sc, Menu menu) {
            while (true) {
                System.out.println("THIS IS CUSTOMER MENU: ");
                System.out.println("1. Add Item to Cart");
                System.out.println("2. View Cart");
                System.out.println("3. Checkout / Make Payment");
                System.out.println("4. View Purchase History");
                System.out.println("5. Track Order");
                System.out.println("6.Exit");
                System.out.println("Enter Your Choice: ");

                int choice = 0;
                try {
                    choice = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number. ");
                    sc.nextLine();
                    continue;
                }
                sc.nextLine();

                switch (choice) {
                    case 1:
                        cart.addCartItem(menu);
                        break;
                    case 2:
                        cart.viewCart();
                        break;
                    case 3:
                        if (cart.checkout()) {
                            if (historyCount < 10) {
                                shoppingCartHistory[historyCount++] = cart;
                            }
                            cart = new ShoppingCart();
                        }
                        break;
                    case 4:
                        viewPurchaseHistory();
                        break;
                    case 5:
                        trackOrders();
                        break;
                    case 6:
                        logout();
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }

        public void viewPurchaseHistory() {
            if (historyCount == 0) {
                System.out.println("No Purchase History Yet. ");
                return;
            }
            System.out.println("=====Purchase History===== ");
            for (int i = 0; i < historyCount; i++) {
                System.out.println("Cart: " + (i + 1) +" (Cart Code: " +shoppingCartHistory[i].getCartCode() + "):");
                shoppingCartHistory[i].viewCart();
                System.out.println("Total Amount: RM" +shoppingCartHistory[i].getTotalAmount());
            }
        }

        public void trackOrders() {
            if (historyCount == 0) {
                System.out.println("You have no orders to track.");
                return;
            }
            ShoppingCart lastOrder = shoppingCartHistory[historyCount - 1];

            System.out.println("Tracking Latest Order: ");
            lastOrder.showOrderStatus();
            lastOrder.advanceOrderStatus();
        }
    }
}*/
