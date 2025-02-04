package CashWithdrawChain;

import ATM.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor {
    public OneHundredWithdrawProcessor(CashWithdrawProcessor processor) {
        super(processor);
    }

    public void withdraw(ATM atm, int amount) {
        int requiredNotes = amount / 100;
        int remainingAmount = amount % 100;

        if (requiredNotes <= atm.getNumOf100()) {
            atm.deductNumOf100(requiredNotes);
        } else {
            atm.deductNumOf100(atm.getNumOf100() - requiredNotes);
            remainingAmount = remainingAmount + (requiredNotes - atm.getNumOf100()) * 100;
        }
        if (remainingAmount != 0) System.out.println("Something went wrong");
    }
}
