package User;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Integer, Integer> productInventoryIdVsCount;

    Cart() {
        productInventoryIdVsCount = new HashMap<>();
    }

    // add item to cart
    public void addItemInCart(int productInventoryId, int quantity) {
        if (productInventoryIdVsCount.containsKey(productInventoryId)) {
            productInventoryIdVsCount.put(productInventoryId, productInventoryIdVsCount.get(productInventoryId) + quantity);
        } else {
            productInventoryIdVsCount.put(productInventoryId, quantity);
        }
    }

    // remove item from cart
    public void removeItemFromCart(int productInventoryId, int quantity) {
        if (productInventoryIdVsCount.containsKey(productInventoryId)) {
            int oldQuantity = productInventoryIdVsCount.get(productInventoryId);
            if (quantity - oldQuantity == 0) {
                productInventoryIdVsCount.remove(productInventoryId);
            } else {
                productInventoryIdVsCount.put(productInventoryId, oldQuantity - quantity);
            }
        }
    }

    // empty cart
    public void emptyCart() {
        productInventoryIdVsCount = new HashMap<>();
    }

    // view cart
    public Map<Integer, Integer> getCartItems() {
        return productInventoryIdVsCount;
    }
}
