package Observer;

import Observable.Observable;

public class EmailAlertObserver implements Observer {
    String email;
    Observable observable;

    public EmailAlertObserver(Observable observable, String email) {
        this.observable = observable;
        this.email = email;
    }

    @Override
    public void update() {
        System.out.println("Email Alert: " + email);
    }
}
