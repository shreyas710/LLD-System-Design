public class PercentageCouponDecorator extends CouponDecorator {
    Product product;
    int percentage;

    PercentageCouponDecorator(Product product, int percentage) {
        this.product = product;
        this.percentage = percentage;
    }

    @Override
    public double getPrice() {
        return product.getPrice() - (product.getPrice() * percentage) / 100;
    }
}
