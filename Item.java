
import java.util.*;

public class Item {
    Scanner sc = new Scanner(System.in);

    private String[] itemName = new String[100];
    private String[] itemCode = new String[100];
    private double[] itemPrice = new double[100];
    private int[] quantity = new int[100];
    int count = 0;

    void setItem(String iName, String iCode, double iPrice, int qty) {
        itemName[count] = iName;
        itemCode[count] = iCode;
        itemPrice[count] = iPrice;
        quantity[count] = qty;
        count++;
    }

    public String getItemName(int index) {
        return itemName[index];
    }

    public String getItemCode(int index) {
        return itemCode[index];
    }

    public double getItemPrice(int index) {
        return itemPrice[index];
    }

    public int getQuantity(int index) {
        return quantity[index];
    }

    public int getCount() {
        return count;
    }

    void displayItem() {
        if (count == -1) {
            System.out.println("Item not found!");
            return;
        }

        System.out.printf("%-10s %-25s %-12s %-10s\n", "Code", "Item Name", "Price", "Quantity");
        System.out.println("--------------------------------------------------------------------------------");

        // Print each item
        for (int j = 0; j < count; j++) {
            System.out.printf("%-10s %-25s RM%-10.2f %-10d\n",
                    itemCode[j], itemName[j], itemPrice[j], quantity[j]);
        }


    }

    void addItem() {
        System.out.println("======Add Item=====");
        System.out.println("Code" + "\t" + "Item Name" + "\t\t\t" + "Price" + "\t\t" + "Available Stock");
        displayItem();
        System.out.print("Please enter item name :");
        String iName = sc.nextLine();
        System.out.print("Please enter item code :");
        String iCode = sc.nextLine();
        System.out.print("Please enter price :");
        double iPrice = sc.nextDouble();
        System.out.print("Please enter item quantity :");
        int qty = sc.nextInt();

        sc.nextLine();

        setItem(iName, iCode, iPrice, qty);

    }

    void deleteItem() {
        System.out.println("====== Delete Item ======");
        System.out.println("Code" + "\t" + "Item Name" + "\t\t\t" + "Price" + "\t\t" + "Available Stock");
        displayItem();
        System.out.print("Please enter item name to delete: ");
        String delName = sc.nextLine();

        int del = -1;

        for (int i = 0; i < count; i++) {
            if (itemName[i].equalsIgnoreCase(delName)) {
                del = i;
                break;
            }
        }

        if (del == -1) {
            System.out.println("Item not found!");
            return;
        }

        for (int i = del; i < count - 1; i++) {
            itemName[i] = itemName[i + 1];
            itemCode[i] = itemCode[i + 1];
            itemPrice[i] = itemPrice[i + 1];
            quantity[i] = quantity[i + 1];
        }

        itemName[count - 1] = null;
        itemCode[count - 1] = null;
        itemPrice[count - 1] = 0;
        quantity[count - 1] = 0;

        count--;

        System.out.println("Item deleted successfully!");
    }


    void changeItemDetails() {
        System.out.println("====== Change Item Details ======");
        System.out.println("Code" + "\t" + "Item Name" + "\t\t\t" + "Price" + "\t\t" + "Available Stock");
        displayItem();
        System.out.print("Enter item name to edit: ");
        String searchName = sc.nextLine();

        int k = -1;

        // Find item
        for (int i = 0; i < count; i++) {
            if (itemName[i].equalsIgnoreCase(searchName)) {
                k = i;
                break;
            }
        }

        if (k == -1) {
            System.out.println("Item not found!");
            return;
        }

        // Show current details
        System.out.println("Current Details:");
        System.out.println("----------------------");
        System.out.println("Name     : " + itemName[k]);
        System.out.println("Code     : " + itemCode[k]);
        System.out.println("Price    : " + itemPrice[k]);
        System.out.println("Quantity : " + quantity[k]);
        System.out.println("----------------------");

        // Ask for new details
        System.out.print("Enter new name (- to keep current): ");
        String newName = sc.nextLine();
        if (!newName.equals("-")) {
            itemName[k] = newName;
        }

        System.out.print("Enter new code (- to keep current): ");
        String newCode = sc.nextLine();
        if (!newCode.equals("-")) {
            itemCode[k] = newCode;
        }

        System.out.print("Enter new price (-1 to keep current): ");
        double newPrice = sc.nextDouble();
        if (newPrice != -1) {
            itemPrice[k] = newPrice;
        }

        System.out.print("Enter new quantity (-1 to keep current): ");
        int newQty = sc.nextInt();
        sc.nextLine();
        if (newQty != -1) {
            quantity[k] = newQty;
        }

        System.out.println("Item updated successfully!");
    }


    public void ManageItem() {
        int choiceMI;
        do {
            System.out.println("-------------------------------");
            System.out.println("Welcome to manage item menu");
            System.out.println("-------------------------------");
            System.out.println("1.Add Item");
            System.out.println("2.Delete Item");
            System.out.println("3.Change Item Details");
            System.out.println("4.Exit");
            System.out.print("Please enter your choice : ");
            choiceMI = sc.nextInt();

            sc.nextLine();

            switch (choiceMI) {

                case 1:
                    addItem();
                    break;

                case 2:
                    deleteItem();
                    break;

                case 3:
                    changeItemDetails();
                    break;

                case 4:
                    System.out.println("Exiting......");
                    return;


                default:
                    System.out.println("You entered an invalid options");
                    return;
            }
        } while (true);
    }

    public void setQuantity(int index, int qty) {
        if (index >= 0 && index < count) {
            quantity[index] = qty;
        } else {
            System.out.println("Come Back Again Tommorrow");
        }
    }
}