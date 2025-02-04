package States;

import ATM.ATM;
import ATM.Card;
import ATM.TransactionType;

public abstract class ATMState {
    public void insertCard(ATM atm, Card card) {
        System.out.println("Something went wrong...");
    }

    public void authenticatePin(ATM atm, Card card, int pin) {
        System.out.println("Something went wrong...");
    }

    public void selectOperation(ATM atm, Card card, TransactionType operation) {
        System.out.println("Something went wrong...");
    }

    public void cashWithdrawal(ATM atm, Card card, int amount) {
        System.out.println("Something went wrong...");
    }

    public void displayBalance(ATM atm, Card card) {
        System.out.println("Something went wrong...");
    }

    public void ejectCard() {
        System.out.println("Something went wrong...");
    }

    public void exit(ATM atm) {
        System.out.println("Something went wrong...");
    }
}
