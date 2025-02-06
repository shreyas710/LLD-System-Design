import Balance.BalanceSheetController;
import Expense.ExpenseSplitType;
import Expense.Split.Split;
import Group.Group;
import Group.GroupController;
import User.User;
import User.UserController;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {
    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    Splitwise() {
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public void demo() {
        setupUserAndGroup();

        Group group = groupController.getGroup("G101");
        group.addUser(userController.getUser("102"));
        group.addUser(userController.getUser("103"));

        List<Split> splits = new ArrayList<>();
        Split split1 = new Split(userController.getUser("101"), 300);
        Split split2 = new Split(userController.getUser("102"), 300);
        Split split3 = new Split(userController.getUser("103"), 300);
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);
        group.createExpense("E101", "Breakfast", 900, splits, ExpenseSplitType.EQUAL, userController.getUser("101"));

        List<Split> split_2 = new ArrayList<>();
        Split split2_1 = new Split(userController.getUser("101"), 400);
        Split split2_2 = new Split(userController.getUser("102"), 100);
        split_2.add(split2_1);
        split_2.add(split2_2);
        group.createExpense("E102", "Lunch", 500, split_2, ExpenseSplitType.UNEQUAL, userController.getUser("102"));

        for (User user : userController.getUserList()) {
            balanceSheetController.showBalanceSheet(user);
        }
    }

    public void setupUserAndGroup() {
        addUsersToSplitwiseApp();

        User user1 = userController.getUser("101");
        groupController.createGroup("G101", "Outting with friends", user1);
    }

    public void addUsersToSplitwiseApp() {
        User user1 = new User("101", "User 1");
        User user2 = new User("102", "User 2");
        User user3 = new User("103", "User 3");
        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
    }
}
