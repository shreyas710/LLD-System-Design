import Pizza.BasePizza;
import Pizza.Margherita;
import Toppings.ExtraCheese;
import Toppings.Mushroom;

public class Main {
    public static void main(String[] args) {
        BasePizza pizza = new ExtraCheese(new Mushroom(new ExtraCheese(new Margherita())));
        System.out.println(pizza.cost());
    }
}