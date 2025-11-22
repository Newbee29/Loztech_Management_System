
public class Report {
    private String orderHistory="";
    private int totalOrders=0;
    private double totalSpent=0.00;
    private double totalSales;



    public void addOrder(ShoppingCart cart, Payment payment){
        totalOrders++;
        totalSpent +=payment.getAmountPaid();
        orderHistory += "Order " +totalOrders + "\t(ID: " +cart.getCartCode() + ")" + "\tRM" + String.format("%.2f", payment.getAmountPaid()) + "\n" ;
    }

    public void displayCustomerReport(){
        System.out.println("=====PURCHASE REPORT=====");
        System.out.println("Total Orders Placed: " +totalOrders);
        System.out.println("Cumulative Total Spent:\tRM" + String.format("%.2f",totalSpent));
        System.out.println("-----Order History-----");
        System.out.println(orderHistory);
    }

    public void addSales(Payment payment) {
        totalSales += payment.getAmountPaid();
    }


    public void displaySales(){
        System.out.println("===== Sales Report =====");
        if(totalSales==0){
            System.out.println("Still no sales yet today...");
        }else {
            System.out.println("Total Sales : RM" + totalSales);
        }
        System.out.println("========================");
    }

}