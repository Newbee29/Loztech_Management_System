import java.util.*;

public class Item {
    Scanner scn= new Scanner(System.in);

    public void ManageItem(){
        int choiceMI;
        System.out.println("-------------------------------");
        System.out.println("Welcome to manage item menu");
        System.out.println("-------------------------------");
        System.out.println("1.Add Item");
        System.out.println("2.Delete Item");
        System.out.println("3.Change Item Details");
        System.out.println("4.Exit");
        System.out.print("Please enter your choice : ");
        choiceMI= scn.nextInt();

        scn.nextLine();
        switch (choiceMI){

            case 1:
                //additem method;
                break;

            case 2:
                //delete item method;
                break;

            case 3:
                //changeitemdetail method;
                break;

            case 4:
                System.out.println("Exiting......");
                return;


            default:
                System.out.println("You entered an invalid options");
                return;
        }

    }


}
