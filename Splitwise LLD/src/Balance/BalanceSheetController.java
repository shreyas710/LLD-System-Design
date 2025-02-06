package Balance;

import Expense.Split.Split;
import User.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User paidByUser, List<Split> splits, double totalExpense) {
        // update total amount paid of paidByUser
        UserExpenseBalanceSheet paidByUserBalanceSheet = paidByUser.getUserExpenseBalanceSheet();
        paidByUserBalanceSheet.setTotalPayment(paidByUserBalanceSheet.getTotalPayment() + totalExpense);

        for (Split split : splits) {
            User userOwe = split.getUser();
            UserExpenseBalanceSheet oweByUserBalanceSheet = userOwe.getUserExpenseBalanceSheet();
            double oweAmount = split.getAmountOwe();

            if (paidByUser.getUserId().equals(userOwe.getUserId())) {
                paidByUserBalanceSheet.setTotalExpense(paidByUserBalanceSheet.getTotalExpense() + oweAmount);
            } else {
                // update balance of paid user
                paidByUserBalanceSheet.setTotalGetBack(paidByUserBalanceSheet.getTotalGetBack() + oweAmount);

                Balance userOweBalance;
                if (paidByUserBalanceSheet.getUserBalanceMap().containsKey(userOwe.getUserId())) {
                    userOweBalance = paidByUserBalanceSheet.getUserBalanceMap().get(userOwe.getUserId());
                } else {
                    userOweBalance = new Balance();
                    paidByUserBalanceSheet.getUserBalanceMap().put(userOwe.getUserId(), userOweBalance);
                }
                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + oweAmount);

                // update balance of owe user
                oweByUserBalanceSheet.setTotalOwe(oweByUserBalanceSheet.getTotalOwe() + oweAmount);
                oweByUserBalanceSheet.setTotalExpense(oweByUserBalanceSheet.getTotalExpense() + oweAmount);

                Balance userPaidBalance;
                if (oweByUserBalanceSheet.getUserBalanceMap().containsKey(paidByUser.getUserId())) {
                    userPaidBalance = oweByUserBalanceSheet.getUserBalanceMap().get(paidByUser.getUserId());
                } else {
                    userPaidBalance = new Balance();
                    oweByUserBalanceSheet.getUserBalanceMap().put(paidByUser.getUserId(), userPaidBalance);
                }
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount);
            }

        }
    }

    public void showBalanceSheet(User paidByUser) {
        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + paidByUser.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet = paidByUser.getUserExpenseBalanceSheet();

        System.out.println("Total Expense: " + userExpenseBalanceSheet.getTotalExpense());
        System.out.println("Total Payment Made: " + userExpenseBalanceSheet.getTotalPayment());
        System.out.println("Total Get Back: " + userExpenseBalanceSheet.getTotalGetBack());
        System.out.println("Total Owe: " + userExpenseBalanceSheet.getTotalOwe());

        for (Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserBalanceMap().entrySet()) {
            String userID = entry.getKey();
            Balance balance = entry.getValue();
            System.out.println("userID: " + userID + " YouGetBack: " + balance.getAmountGetBack() + " YouOwe: " + balance.getAmountOwe());
        }

        System.out.println("---------------------------------------");

    }
}
