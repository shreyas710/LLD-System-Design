package ATM;

public class Card {
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private String holderName;
    static int PIN = 112233;
    private BankAccount bankAccount;

    public boolean isCorrectPin(int pin) {
        return pin == PIN;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getBankBalance() {
        return bankAccount.balance;
    }

    public void deductBankBalance(int amount) {
        bankAccount.withdrawBalance(amount);
    }
}
