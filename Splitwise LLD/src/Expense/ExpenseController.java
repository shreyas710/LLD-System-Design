package Expense;

import Balance.BalanceSheetController;
import Expense.Split.ExpenseSplit;
import Expense.Split.Split;
import User.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double amount, List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {
        ExpenseSplit expenseSplit = SplitFactory.getSplit(splitType);
        expenseSplit.validateSplitRequest(splitDetails, amount);

        Expense expense = new Expense(expenseId, description, amount, paidByUser, splitType, splitDetails);
        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, amount);
        return expense;
    }
}
