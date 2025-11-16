import java.util.*;

public class Item {
    Scanner scn= new Scanner(System.in);

    private String[] itemName= new String[100];
    private String[] itemCode= new String[100];
    private double[] itemPrice= new double[100];
    private int[] quantity= new int[100];
    int count=0;

    void setItem(String iName, String iCode, double iPrice, int qty){
        itemName[count] = iName;
        itemCode[count] = iCode;
        itemPrice[count] = iPrice;
        quantity[count] = qty;
    }

    public String getItemName(int count){return itemName[count];
    }

    public String getItemCode(int count){return itemCode[count];
    }

    public double getItemPrice(int count){return itemPrice[count];
    }

    public int getQuantity(int count){return quantity[count];
    }
    Item item = new Item();

    void addItem(){
        System.out.println("======Add Item=====");
        System.out.print("Please enter item name :");
        String iName= scn.nextLine();
        System.out.print("Please enter item code :");
        String iCode= scn.nextLine();
        System.out.print("Please enter price :");
        double iPrice= scn.nextDouble();
        System.out.print("Please enter item quantity :");
        int qty= scn.nextInt();

        scn.nextLine();

        item.setItem(iName, iCode, iPrice, qty);
        count++;

    }


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
                addItem();
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
