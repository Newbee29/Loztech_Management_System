import java.util.*;

public class User {
    private String accessCode = "Loz123";
    private String[] userName = new String[100];
    private String[] password = new String[100];
    private String[] role = new String[100];

    int countt=0;
    void setUser(String uName, String pWord, String rLe){
        userName[countt]=uName;
        password[countt]=pWord;
        role[countt]=rLe;
        countt++;
    }

    Scanner scn = new Scanner(System.in);
     public void register(){
         System.out.print("Enter your Username : ");
         String uName=scn.nextLine();
         System.out.print("Enter your Password : ");
         String pWord= scn.nextLine();
         System.out.print("Enter your role(customer/manager) : ");
         String rLe=scn.nextLine();
         if (Objects.equals(rLe, "manager")) {
             System.out.print("Please enter your access CODE :");
             accessCode = scn.nextLine();
             if (!accessCode.equals("Loz123")) {
                 System.out.println("You entered an invalid access code...");
                 return;
             }
         }

         setUser(uName, pWord, rLe);
         System.out.println("You've successfully registered......");

     }

     public void login(){
         boolean search = false;
         int index = 0;
         System.out.print("Username :");
         String loginUser = scn.nextLine();
         System.out.print("Password :");
         String loginPassword = scn.nextLine();


         for (int i = 0; i < countt; i++) {
             if (userName[i].equals(loginUser) && password[i].equals(loginPassword)) {
                 search = true;
                 index = i;
                 break;
             }
         }

         if (!search) {
             System.out.println("You've entered an invalid username & password...... ");
             return;
         }

         if (role[index].equals("manager")) {
             System.out.println("You've successfully login to a manager account...");
             Manager manager = new Manager();
             manager.managerMenu();
         } else {
             System.out.println("You've successfully login to a customer account...");
             //customerMenu();
         }

     }
}
