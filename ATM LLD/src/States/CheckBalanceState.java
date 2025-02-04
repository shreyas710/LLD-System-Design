package States;

import ATM.ATM;
import ATM.Card;

public class CheckBalanceState extends ATMState {
    public CheckBalanceState() {

    }

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your balance is: " + card.getBankBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atm) {
        ejectCard();
        atm.setCurrentState(new IdleState());
        System.out.println("EXITED");
    }

    @Override
    public void ejectCard() {
        System.out.println("Collect your card");
    }
}
