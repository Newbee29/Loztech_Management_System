import java.util.*;


public class Main{
    public static void main(String[] args){

        String accessCode;
        String[] userName = new String[100];
        String[] password = new String[100];
        String[] role = new String[100];
        int choice1, count = 0;
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
                    System.out.print("Please enter your username :");
                    String newUser = scn.nextLine();
                    System.out.print("Please enter your password :");
                    String newPass = scn.nextLine();
                    ;
                    System.out.print("Please enter your role(manager/customer) :");
                    String newRole = scn.nextLine();
                    if (Objects.equals(newRole, "manager")) {
                        System.out.print("Please enter your access CODE :");
                        accessCode = scn.nextLine();
                        if (!accessCode.equals("Loz123")) {
                            System.out.println("You entered an invalid access code...");
                            break;
                        }
                    }


                    userName[count] = newUser;
                    password[count] = newPass;
                    role[count] = newRole;
                    count++;

                    System.out.println("You've successfully registered......");
                    break;


                case 2:
                    boolean search = false;
                    int index = 0;
                    System.out.print("Username :");
                    String loginUser = scn.nextLine();
                    System.out.print("Password :");
                    String loginPassword = scn.nextLine();
                    ;

                    for (int i = 0; i < count; i++) {
                        if (userName[i].equals(loginUser) && password[i].equals(loginPassword)) {
                            search = true;
                            index = i;
                            break;
                        }
                    }

                    if (!search) {
                        System.out.println("You've entered an invalid username & password...... ");
                        break;
                    }

                    if (role[index].equals("manager")) {
                        System.out.println("You've successfully login to a manager account...");
                        Manager manager = new Manager();
                        manager.managerMenu();
                    } else {
                        System.out.println("You've successfully login to a customer account...");
                        //customerMenu();
                    }

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