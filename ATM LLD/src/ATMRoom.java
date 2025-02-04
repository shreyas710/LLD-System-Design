import ATM.ATM;
import ATM.User;
import ATM.Card;
import ATM.BankAccount;
import ATM.TransactionType;

public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printATM();
        atmRoom.atm.getCurrentState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getCurrentState().authenticatePin(atmRoom.atm, atmRoom.user.getCard(), 112233);
        atmRoom.atm.getCurrentState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.WITHDRAWAL);
        atmRoom.atm.getCurrentState().cashWithdrawal(atmRoom.atm, atmRoom.user.getCard(), 2700);
        atmRoom.atm.printATM();
    }

    public void initialize() {
        this.atm = ATM.getAtm();
        atm.setAtmBalance(3500, 1, 2, 5);

        this.user = createUser();
    }

    public User createUser() {
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    public Card createCard() {
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    public BankAccount createBankAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(3000);
        return bankAccount;
    }
}