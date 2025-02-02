package VendingMachine;

import States.State;
import States.impl.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State state;
    private Inventory inventory;
    private List<Coin> coins;

    public VendingMachine() {
        state = new IdleState();
        inventory = new Inventory(10);
        coins = new ArrayList<>();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }
}
