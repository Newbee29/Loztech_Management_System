
import java.util.Scanner;

public class ShoppingCart {
    Scanner sc = new Scanner(System.in);
    private static int cartCounter = 100;
    private int cartCode;
    private Item[] items = new Item[10];
    private double[] quantities = new double[10];
    private int itemCount = 0;
    private double totalAmount = 0.00;
    private int orderStatus = 0;
    private final String[] statusList = {"Confirm Your Order", "Preparing", "Finished"};

    public ShoppingCart() {
        this.cartCode = cartCounter++;
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

    public void addCartItem(Menu menu) {
        if (itemCount >= 10) {
            System.out.println("Cart Full!");
            return;
        }
        if (menu.getItemCount() == 0) {
            System.out.println("Today Shop Is Close!");
            return;
        }

        menu.displayMenu();
        int i=-1;

        while (true) {
            System.out.print("Enter Item Number: ");
            if (sc.hasNextInt()) {
                i = sc.nextInt() - 1;
                sc.nextLine();
                if (i >= 0 && i < menu.getItemCount()) {
                    break;
                } else {
                    System.out.println("🚫Invalid item number!");
                }
            } else {
                System.out.println("🚫Invalid Input! Please Enter A Number! ");
                sc.nextLine();
            }
        }

        Item selected = menu.getItem(i);
        double qty=0;


        while(true) {
            System.out.print("Enter Quantity: " + selected.itemName);
            if (sc.hasNextDouble()) {
                qty = sc.nextDouble();
                sc.nextLine();
                if (qty <= 0) {
                    System.out.println("🚫Quantity Must Be Positive");
                } else if (qty > selected.stock) {
                    System.out.println("🚫Cannot Purchase. Only In Stock"
                            + selected.stock);
                } else {
                    break;
                }
            } else {
                System.out.println("🚫Error: Please Enter A Valid Number For Quantity!");
                sc.nextLine();
            }
        }

        items[itemCount] = selected;
        quantities[itemCount] = qty;
        totalAmount += selected.itemPrice * qty;
        itemCount++;

        System.out.println(selected.itemName + "Added to Cart!");
    }

    public void viewCart() {
        if (itemCount == 0) {
            System.out.println("Cart Empty!");
            return;
        }

        System.out.println("=====SHOPPING CART=====");
        System.out.println("No. | Item Name        | Qty   | Subtotal");
        System.out.println("----------------------------");
        for(int i=0;i<itemCount; i++){
            double subtotal =items[i].itemPrice * quantities[i];
            System.out.println(String.format("%-3d | %-15s | %-5.0f | RM%-7.2f", i + 1, items[i].itemName, quantities[i], subtotal));
        }
        System.out.println("---------------------------");
        System.out.println(String.format("%-26s RM%-9.2f", "Total Cart Subtotal:", totalAmount));
    }

    public boolean isEmpty() {
        return itemCount==0;
    }

    public void reduceStock() {
        for (int i = 0; i < itemCount; i++) {
            items[i].stock -= (int) quantities[i];
        }
    }

    public void printReceipt(double amountPaid, String paymentMethod){
        System.out.println("=====RECEIPTS=====");
        System.out.println(String.format("%-15s %-5s %-10s %-10s", "Item", "Qty", "Price", "Subtotal"));
        System.out.println("-------------------------------------------------------------------------");
        for(int i=0;i<itemCount;i++){
            double subtotal=items[i].itemPrice * quantities[i];
            System.out.println(String.format("%-15s %-5.0f RM%-9.2f RM%-9.2f", items[i].itemName, quantities[i], items[i].itemPrice, subtotal));
        }
        System.out.println("------------------------------------");
        System.out.println(String.format("%-27s RM%-10.2f", "Total Paid:", amountPaid));
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("====================================");
    }
}