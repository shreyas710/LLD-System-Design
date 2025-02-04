package Toppings;

import Pizza.BasePizza;

public class Mushroom extends Decorator {
    BasePizza pizza;

    public Mushroom(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return pizza.cost() + 15;
    }
}
