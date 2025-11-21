import java.util.*;

public class ShoppingCart {
    private static int cartCounter = 100;
    private int cartCode;
    private Item sharedItem;              // the shared Item object
    private int[] itemIndexes = new int[10];  // index of each item in Item arrays
    private double[] quantities = new double[10];
    private int itemCount = 0;
    private double totalAmount = 0.0;

    private int orderStatus = 0;
    private final String[] statusList = {"Confirm Your Order", "Preparing", "Finished"};

    private Scanner sc = new Scanner(System.in);

    public ShoppingCart(Item sharedItem) {
        this.cartCode = cartCounter++;
        this.sharedItem = sharedItem; // keep the shared reference
    }

    public int getCartCode() {
        return cartCode;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void showOrderStatus() {
        System.out.println("Current Status: " + statusList[orderStatus]);
    }

    public void advanceOrderStatus() {
        if (orderStatus < statusList.length - 1) {
            orderStatus++;
            System.out.println("Order Moved To: " + statusList[orderStatus]);
        } else {
            System.out.println("Order Already Finished!");
        }
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public void addCartItem(Menu menu) {
        if (itemCount >= 10) {
            System.out.println("Cart Full!");
            return;
        }

        if (sharedItem.getCount() == 0) {
            System.out.println("Today Shop Is Closed!");
            return;
        }

        // Display all items
        System.out.println("===== MENU =====");
        sharedItem.displayItem();
        String code;

        int index = -1;
        while (true) {
            System.out.print("Enter Item Code to Add: ");
            code = sc.nextLine();

            for (int i = 0; i < sharedItem.getCount(); i++) {
                if (sharedItem.getItemCode(i).equalsIgnoreCase(code)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) break;
            System.out.println("Invalid code! Try again.");
        }

        double qty = 0;
        while (true) {
            System.out.print("Enter Quantity for " + sharedItem.getItemName(index) + ": ");
            if (sc.hasNextDouble()) {
                qty = sc.nextDouble();
                sc.nextLine();
                if (qty <= 0) {
                    System.out.println("Quantity must be positive!");
                } else if (qty > sharedItem.getQuantity(index)) {
                    System.out.println("Cannot purchase. Only " + sharedItem.getQuantity(index) + " in stock.");
                } else {
                    break;
                }
            } else {
                System.out.println("Invalid number for quantity!");
                sc.nextLine();
            }
        }

        // Store in cart
        itemIndexes[itemCount] = index;   // store the index
        quantities[itemCount] = qty;
        totalAmount += sharedItem.getItemPrice(index) * qty;
        itemCount++;

        System.out.println(sharedItem.getItemName(index) + " added to cart!");
    }

    public void viewCart() {
        if (itemCount == 0) {
            System.out.println("Cart is empty!");
            return;
        }

        System.out.println("===== SHOPPING CART =====");
        System.out.println("No. | Item Name        | Qty   | Subtotal");
        System.out.println("------------------------------------------");

        for (int i = 0; i < itemCount; i++) {
            int idx = itemIndexes[i];
            double subtotal = sharedItem.getItemPrice(idx) * quantities[i];
            System.out.println(String.format("%-3d | %-15s | %-5.0f | RM%-7.2f",
                    i + 1, sharedItem.getItemName(idx), quantities[i], subtotal));
        }

        System.out.println("------------------------------------------");
        System.out.println(String.format("%-26s RM%-9.2f", "Total Cart Subtotal:", totalAmount));
    }

    public void reduceStock() {
        for (int i = 0; i < itemCount; i++) {
            int idx = itemIndexes[i];
            int newStock = sharedItem.getQuantity(idx) - (int) quantities[i];
            sharedItem.setQuantity(idx, newStock); // modifies shared Item
        }
    }

    public void printReceipt(double amountPaid, String paymentMethod) {
        System.out.println("===== RECEIPT =====");
        System.out.println(String.format("%-15s %-5s %-10s %-10s", "Item", "Qty", "Price", "Subtotal"));
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < itemCount; i++) {
            int idx = itemIndexes[i];
            double subtotal = sharedItem.getItemPrice(idx) * quantities[i];
            System.out.println(String.format("%-15s %-5.0f RM%-9.2f RM%-9.2f",
                    sharedItem.getItemName(idx), quantities[i], sharedItem.getItemPrice(idx), subtotal));
        }

        System.out.println("------------------------------------");
        System.out.println(String.format("%-27s RM%-10.2f", "Total Paid:", amountPaid));
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("====================================");
    }
}
