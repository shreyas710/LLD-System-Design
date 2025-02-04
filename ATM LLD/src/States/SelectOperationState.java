package States;

import ATM.ATM;
import ATM.TransactionType;
import ATM.Card;

public class SelectOperationState extends ATMState {
    public SelectOperationState() {
        showOperations();
    }

    private void showOperations() {
        System.out.println("Select Operation");
        TransactionType.showAllTransactionTypes();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        switch (transactionType) {
            case WITHDRAWAL -> atm.setCurrentState(new CashWithdrawalState());
            case CHECK_BALANCE -> atm.setCurrentState(new CheckBalanceState());
            default -> {
                System.out.println("Invalid transaction type");
                exit(atm);
            }
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
