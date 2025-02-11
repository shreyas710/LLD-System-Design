package Order;

import Product.Address;
import Product.Warehouse;
import User.User;

import java.util.Map;

public class Order {
    User user;
    Address deliveryAddress;
    Map<Integer, Integer> productInventoryVsCount;
    Warehouse warehouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;

    Order(User user, Warehouse warehouse) {
        this.user = user;
        this.warehouse = warehouse;
        this.productInventoryVsCount = user.getCart().getCartItems();
        this.deliveryAddress = user.address;
        this.invoice = new Invoice();
        invoice.generateInvoice(this);
    }

    public void checkOut() {
        // update inventory
        warehouse.removeItemFromInventory(productInventoryVsCount);

        // make payment
        boolean isPaymentSuccessful = makePayment(new UPIPaymentMode());

        // make cart empty
        if (isPaymentSuccessful) {
            user.getCart().emptyCart();
        } else {
            warehouse.addItemToInventory(productInventoryVsCount);
        }
    }

    public boolean makePayment(PaymentMode paymentMode){
        payment = new Payment(paymentMode);
        return payment.makePayment();
    }

    public void generateOrderInvoice(){
        invoice.generateInvoice(this);
    }

}
