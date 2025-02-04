package Observer;

import Observable.Observable;

public class MobileAlertObserver implements Observer {
    String username;
    Observable observable;

    public MobileAlertObserver(Observable observable, String username) {
        this.username = username;
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Mobile Alert: " + username);
    }
}
