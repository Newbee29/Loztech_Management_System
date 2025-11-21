import java.util.*;

public class Payment {
    private double amountPaid;
    private String paymentMethod;
    private double subtotal;
    private double serviceTax;
    private double SST;
    private double packagingFee;

    public Payment(double subtotal){
        this.subtotal=subtotal;
        this.serviceTax=subtotal * 0.05;
        this.SST=subtotal * 0.06;
        this.packagingFee=2.0;
        this.amountPaid=subtotal + serviceTax + SST + packagingFee;
    }

    public void makePayment(Scanner sc) {
        System.out.println("====CHECKOUT SUMMARY=====");
        System.out.println(String.format("%-20s RM%-10.2f", "Subtotal:" , subtotal));
        System.out.println(String.format("%-20s RM%-10.2f", "ServiceTax(5%):", serviceTax));
        System.out.println(String.format("%-20s RM%-10.2f", "SST (6%):", SST));
        System.out.println(String.format("%-20s RM%-10.2f", "Packaging Fee:", packagingFee));
        System.out.println("--------------------------------");
        System.out.println(String.format("%-20s RM%-10.2f", "TOTAL:", amountPaid));

        System.out.print("Enter Payment Method (Cash/Card/QR): ");
        paymentMethod = sc.nextLine();
        confirmPayment();
    }
    public void confirmPayment(){
        System.out.println("Payment Confirmed!" );
    }
    public void getReceipt(ShoppingCart cart){
        cart.printReceipt(amountPaid,paymentMethod);
    }

    public double getAmountPaid(){
        return amountPaid;
    }

    public String getPaymentMethod(){
        return paymentMethod;
    }
}