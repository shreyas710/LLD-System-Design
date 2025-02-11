import Order.Order;
import Order.OrderController;
import Product.Inventory;
import Product.ProductInventory;
import Product.Warehouse;
import Product.WarehouseController;
import Product.WarehouseSelectionStrategy.WarehouseSelectionStrategy;
import User.User;
import User.UserController;
import User.Cart;

import java.util.List;

public class ProductDeliverySystem {
    UserController userController;
    WarehouseController warehouseController;
    OrderController orderController;

    ProductDeliverySystem(List<User> userList, List<Warehouse> warehouseList){
        userController = new UserController(userList);
        warehouseController = new WarehouseController(warehouseList , null);
        orderController = new OrderController();
    }

    //get user object
    public User getUser(int userId){
        return userController.getUser(userId);
    }

    //get warehouse
    public Warehouse getWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy){
        return warehouseController.selectWarehouse(warehouseSelectionStrategy);

    }

    //get inventory
    public Inventory getInventory(Warehouse warehouse){
        return warehouse.inventory;

    }

    //add product to cart
    public void addProductToCart(User user, ProductInventory product, int count){
        Cart cart = user.getCart();
        cart.addItemInCart(product.productInventoryId, count);
    }

    //place order
    public Order placeOrder(User user, Warehouse warehouse){
        return orderController.createOrder(user, warehouse);
    }

    public void checkout(Order order){
        order.checkOut();
    }
}
