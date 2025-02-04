package States;

import ATM.ATM;
import ATM.Card;

public class HasCardState extends ATMState {
    public HasCardState() {
        System.out.println("Enter your Card PIN");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        boolean isCorrectPin = card.isCorrectPin(pin);
        if (isCorrectPin) {
            atm.setCurrentState(new SelectOperationState());
        } else {
            System.out.println("Wrong PIN Entered");
            exit(atm);
        }
    }
}
