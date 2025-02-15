import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addToCart(Product product) {
        products.add(new TypeCouponDecorator(new PercentageCouponDecorator(product, 10), 3, product.productType));
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}
