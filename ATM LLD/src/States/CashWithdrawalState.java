package States;


import ATM.ATM;
import ATM.Card;
import CashWithdrawChain.CashWithdrawProcessor;
import CashWithdrawChain.FiveHundredWithdrawProcessor;
import CashWithdrawChain.OneHundredWithdrawProcessor;
import CashWithdrawChain.TwoThousandWithdrawProcessor;

public class CashWithdrawalState extends ATMState {
    public CashWithdrawalState() {
        System.out.println("Please enter withdrawal amount");
    }

    public void cashWithdrawal(ATM atm, Card card, int amount) {
        if (atm.getAtmBalance() < amount) {
            System.out.println("ATM Machine does not have enough money to withdraw");
            exit(atm);
        } else if (card.getBankBalance() < amount) {
            System.out.println("Your bank account does not have enough money to withdraw");
            exit(atm);
        } else {
            card.deductBankBalance(amount);
            atm.deductATMBalance(amount);

            CashWithdrawProcessor cashWithdrawProcessor = new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
            cashWithdrawProcessor.withdraw(atm, amount);
            exit(atm);
        }
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
