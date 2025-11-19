public class Menu {
    private Item item = new Item();

    public void displayMenu() {
        System.out.println("==========================Menu==================================");
        System.out.println("Code"+ "\t"+"Item Name"+"\t\t\t"+"Price"+"\t\t"+"Available Stock");
        item.displayItem();
        System.out.println("================================================================");
    }

}
