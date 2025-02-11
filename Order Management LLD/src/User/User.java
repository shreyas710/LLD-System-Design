package User;

import Product.Address;

import java.util.ArrayList;
import java.util.List;

public class User {
    public int userId;
    public String userName;
    public Address address;
    Cart cart;
    List<Integer> orderIds;

    public User() {
        cart = new Cart();
        orderIds = new ArrayList<>();
    }

    // get user cart
    public Cart getCart() {
        return cart;
    }
}
