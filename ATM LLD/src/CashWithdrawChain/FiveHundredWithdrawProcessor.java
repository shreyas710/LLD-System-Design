package CashWithdrawChain;

import ATM.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor {
    public FiveHundredWithdrawProcessor(CashWithdrawProcessor processor) {
        super(processor);
    }

    public void withdraw(ATM atm, int amount) {
        int requiredNotes = amount / 500;
        int remainingAmount = amount % 500;

        if (requiredNotes <= atm.getNumOf500()) {
            atm.deductNumOf500(requiredNotes);
        } else {
            atm.deductNumOf500(atm.getNumOf500());
            remainingAmount = remainingAmount + (requiredNotes - atm.getNumOf500()) * 500;
        }
        if (remainingAmount != 0) super.withdraw(atm, remainingAmount);
    }
}
