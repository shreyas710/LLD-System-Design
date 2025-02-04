package ATM;

public enum TransactionType {
    WITHDRAWAL, CHECK_BALANCE;

    public static void showAllTransactionTypes() {
        for (TransactionType type : TransactionType.values()) {
            System.out.println(type.name());
        }
    }
}
