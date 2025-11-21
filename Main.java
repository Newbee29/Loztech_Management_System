import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Item sharedItem = new Item(); // only one shared item
        Manager manager = new Manager(sharedItem);
        Customer customer = new Customer(sharedItem);
        User user = new User();

        int choice1;
        do {
            System.out.println("--------------------------------------------------");
            System.out.println("\t\t Welcome to LozBakery");
            System.out.println("--------------------------------------------------");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Please enter your choice: ");
            choice1 = sc.nextInt();
            sc.nextLine();

            switch (choice1) {
                case 1:
                    user.register();
                    break;
                case 2:
                    int idx = user.login();
                    if (idx != -1) {
                        if (user.role[idx].equalsIgnoreCase("manager")) {
                            manager.managerMenu();
                        } else {
                            customer.viewCustomer();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (true);
    }
}
