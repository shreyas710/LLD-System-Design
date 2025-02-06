package Group;

import Expense.Expense;
import Expense.Split.Split;
import User.User;
import Expense.ExpenseController;
import Expense.ExpenseSplitType;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> userList;
    List<Expense> expenseList;
    ExpenseController expenseController;

    Group() {
        userList = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Expense createExpense(String expenseId, String description, double amount, List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {
        Expense expense = expenseController.createExpense(expenseId, description, amount, splitDetails, splitType, paidByUser);
        expenseList.add(expense);
        return expense;
    }
}
