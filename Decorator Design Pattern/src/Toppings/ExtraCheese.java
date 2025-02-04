package Toppings;

import Pizza.BasePizza;

public class ExtraCheese extends Decorator {
    BasePizza pizza;

    public ExtraCheese(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return pizza.cost() + 10;
    }
}
