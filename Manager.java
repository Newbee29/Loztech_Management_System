import java.util.*;

public class Manager extends User {

    Scanner sc = new Scanner(System.in);


    Item manageItem;
    private Item sharedItem;
    Report rep= new Report();

    public Manager(Item item) {   // ← receive shared Item
        this.manageItem = item;
        this.sharedItem=item;
    }

    public void managerMenu(){

        int choiceM1;
        System.out.println("------------------------------");
        System.out.println("Welcome to Manager Menu!");
        System.out.println("------------------------------");
        System.out.println("1.Manage Item");
        System.out.println("2.Report");
        System.out.println("3.Exit");
        System.out.print("Please enter your choice : ");
        choiceM1 = sc.nextInt();

        sc.nextLine();

        switch(choiceM1){

            case 1:

                manageItem.ManageItem();
                break;

            case 2:
                rep.displaySales();
                break;

            case 3:
                System.out.println("Exiting.......");
                break;

            default:
                System.out.println("You entered an invalid options......");
                return;

        }


    }


}