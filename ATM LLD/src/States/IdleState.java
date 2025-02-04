package States;

import ATM.ATM;
import ATM.Card;

public class IdleState extends ATMState {
    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card Inserted");
        atm.setCurrentState(new HasCardState());
    }
}
