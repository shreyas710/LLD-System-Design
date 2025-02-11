package Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    public List<ProductInventory> productInventoryList;

    public Inventory(){
        productInventoryList = new ArrayList<>();
    }

    // add productInventory
    public void addProductInventory(int productInventoryId, String name, double price){
        ProductInventory productInventory = new ProductInventory();
        productInventory.price = price;
        productInventory.productInventoryName = name;
        productInventory.productInventoryId = productInventoryId;
        productInventoryList.add(productInventory);
    }

    // add product to productInventory
    public void addProduct(Product product, int productInventoryId){
        ProductInventory productInventory = null;
        for (ProductInventory productInventory1 : productInventoryList) {
            if(productInventory1.productInventoryId == productInventoryId){
                productInventory = productInventory1;
            }
        }
        if (productInventory != null) {
            productInventory.addProduct(product);
        }
    }

    // remove product from productInventory
    public void removeProducts(Map<Integer, Integer> productInventoryCount) {
        for (Map.Entry<Integer, Integer> entry : productInventoryCount.entrySet()) {
            ProductInventory productInventory = getProductCategoryFromID(entry.getKey());
            if (productInventory != null) {
                productInventory.removeProduct(entry.getValue());
            }
        }
    }

    private ProductInventory getProductCategoryFromID(int productCategoryId) {
        for (ProductInventory productInventory : productInventoryList) {
            if(productCategoryId == productInventory.productInventoryId){
                return productInventory;
            }
        }
        return null;
    }
}
