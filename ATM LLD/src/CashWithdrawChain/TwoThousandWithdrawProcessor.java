package CashWithdrawChain;

import ATM.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {
    public TwoThousandWithdrawProcessor(CashWithdrawProcessor processor) {
        super(processor);
    }

    public void withdraw(ATM atm, int amount) {
        int requiredNotes = amount / 2000;
        int remainingAmount = amount % 2000;

        if (requiredNotes <= atm.getNumOf2000()) {
            atm.deductNumOf2000(requiredNotes);
        } else {
            atm.deductNumOf2000(atm.getNumOf2000());
            remainingAmount = remainingAmount + (requiredNotes - atm.getNumOf2000()) * 2000;
        }
        if (remainingAmount != 0) super.withdraw(atm, remainingAmount);
    }
}
