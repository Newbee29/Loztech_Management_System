import java.util.*;

public class Manager {

    Scanner scn = new Scanner(System.in);

    public void managerMenu(){

        int choiceM1;
        System.out.println("------------------------------");
        System.out.println("Welcome to Manager Menu!");
        System.out.println("------------------------------");
        System.out.println("1.Manage Item");
        System.out.println("2.Report");
        System.out.println("3.Exit");
        System.out.print("Please enter your choice : ");
        choiceM1 = scn.nextInt();

        scn.nextLine();

        switch(choiceM1){


            case 1:
                Item manageItem= new Item();
                manageItem.ManageItem();
                break;

            case 2:
                //report();
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
