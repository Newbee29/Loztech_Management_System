import java.util.*;

public class User {
    protected String[] userName = new String[100];
    protected String[] password = new String[100];
    protected String[] role = new String[100];
    protected int countt = 0;

    String accessCode;

    Scanner sc = new Scanner(System.in);

    void setUser(String uName, String pWord, String rLe) {
        userName[countt] = uName;
        password[countt] = pWord;
        role[countt] = rLe;
        countt++;
    }

    public void register() {
        System.out.print("Enter your Username: ");
        String uName = sc.nextLine();
        System.out.print("Enter your Password: ");
        String pWord = sc.nextLine();
        System.out.print("Enter your role (customer/manager): ");
        String rLe = sc.nextLine();
        if (Objects.equals(rLe, "manager")) {
            System.out.print("Please enter your access CODE :");
            accessCode = sc.nextLine();
            if (!accessCode.equals("Loz123")) {
                System.out.println("You entered an invalid access code...");
                return;
            }
        }

            setUser(uName, pWord, rLe);
            System.out.println("You've successfully registered!");
    }

    public int login() {
        System.out.print("Username: ");
        String loginUser = sc.nextLine();
        System.out.print("Password: ");
        String loginPassword = sc.nextLine();

        for (int i = 0; i < countt; i++) {
            if (userName[i].equals(loginUser) && password[i].equals(loginPassword)) {
                System.out.println("Login successful!");
                return i;
            }
        }

        System.out.println("Invalid username or password!");
        return -1;
    }
}
