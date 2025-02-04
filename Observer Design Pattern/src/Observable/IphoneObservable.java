package Observable;

import Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements Observable {
    public List<Observer> observers = new ArrayList<>();
    public int stock = 0;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void setStock(int stock) {
        if (this.stock == 0) {
            notifyObservers();
        }
        this.stock = stock;
    }
}
