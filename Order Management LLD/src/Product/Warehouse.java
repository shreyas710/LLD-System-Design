package Product;

import java.util.Map;

public class Warehouse {
    public Inventory inventory;
    Address address;

    // update inventory
    public void removeItemFromInventory(Map<Integer, Integer> productInventoryCount) {
        inventory.removeProducts(productInventoryCount);
    }

    public void addItemToInventory(Map<Integer, Integer> productInventoryCount) {
        // update items in inventory
    }
}
