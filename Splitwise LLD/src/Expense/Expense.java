package Expense;

import java.util.ArrayList;
import java.util.List;

import Expense.Split.Split;
import User.User;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType expenseSplitType;
    List<Split> splitDetails = new ArrayList<>();

    public Expense(String expenseId, String description, double expenseAmount, User paidByUser, ExpenseSplitType expenseSplitType, List<Split> splitDetails) {
        this.expenseId = expenseId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.paidByUser = paidByUser;
        this.expenseSplitType = expenseSplitType;
        this.splitDetails = splitDetails;
    }
}
