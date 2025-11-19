import java.util.*;


public class Main{
    public static void main(String[] args){
        int choice1;
        User user= new User();
        do{
            Scanner scn = new Scanner(System.in);
            System.out.println("--------------------------------------------------");
            System.out.println("\t\t\t Welcome to LozBakery\t\t\t");
            System.out.println("--------------------------------------------------");



            System.out.println("Do you have registered account before?");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Please enter your choice :");
            choice1 = scn.nextInt();

            scn.nextLine();


            switch (choice1) {
                case 1:
                    user.register();
                    break;

                case 2:
                    user.login();
                    break;


                case 3:
                    System.out.println("Exiting............");
                    return;


                default:
                    System.out.println("You enetred an invalid options......");

            }
        }while(true);

    }
}