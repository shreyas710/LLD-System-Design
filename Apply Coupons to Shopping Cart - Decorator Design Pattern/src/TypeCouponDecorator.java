import java.util.ArrayList;
import java.util.List;

public class TypeCouponDecorator extends CouponDecorator {
    Product product;
    int percentage;
    ProductType productType;
    static List<ProductType> eligibleTypes = new ArrayList<>();
    static {
        eligibleTypes.add(ProductType.FURNITURE);
    }

    TypeCouponDecorator(Product product, int percentage, ProductType productType) {
        this.product = product;
        this.percentage = percentage;
        this.productType = productType;
    }

    @Override
    public double getPrice() {
        if (eligibleTypes.contains(productType)) {
            return product.getPrice() - (product.getPrice() * percentage) / 100;
        }
        return product.getPrice();
    }
}
