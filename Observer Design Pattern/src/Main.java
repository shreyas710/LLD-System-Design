import Observable.Observable;
import Observable.IphoneObservable;
import Observer.Observer;
import Observer.MobileAlertObserver;
import Observer.EmailAlertObserver;

public class Main {
    public static void main(String[] args) {
        Observable iphoneStock = new IphoneObservable();

        Observer o1 = new EmailAlertObserver(iphoneStock, "shreyask@usc.edu");
        Observer o2 = new MobileAlertObserver(iphoneStock, "Madhuri");

        iphoneStock.addObserver(o1);
        iphoneStock.addObserver(o2);

        iphoneStock.setStock(10);
        iphoneStock.setStock(0);
        iphoneStock.setStock(100);
    }
}