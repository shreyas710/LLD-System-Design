package Order;

import Product.Warehouse;
import User.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {
    List<Order> orders;
    Map<Integer, List<Order>> userIdVsOrders;

    public OrderController() {
        orders = new ArrayList<>();
        userIdVsOrders = new HashMap<>();
    }

    // create new order
    public Order createOrder(User user, Warehouse warehouse) {
        Order order = new Order(user, warehouse);
        orders.add(order);
        if (userIdVsOrders.containsKey(user.userId)) {
            List<Order> orders = userIdVsOrders.get(user.userId);
            orders.add(order);
            userIdVsOrders.put(user.userId, orders);
        } else {
            List<Order> userOrders = new ArrayList<>();
            userOrders.add(order);
            userIdVsOrders.put(user.userId, userOrders);
        }
        return order;
    }

    //remove order
    public void removeOrder(Order order){
        //remove order capability goes here
    }

    public List<Order> getOrderByCustomerId(int userId){
        return null;
    }

    public Order getOrderByOrderId(int orderId){
        return null;
    }
}
