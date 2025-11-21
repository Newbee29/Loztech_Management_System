import java.util.*;

public class Menu {

    private Item sharedItem;

    public Menu(Item item) {
        this.sharedItem = item;  // always shared
    }

    public void displayMenu() {
        System.out.println("========================== Menu ==========================");
        sharedItem.displayItem();  // display all items
        System.out.println("=========================================================");
    }

    public int getItemCount() {
        return sharedItem.getCount();
    }

    public Item getSharedItem() {
        return sharedItem; // always return the shared Item object
    }
}
