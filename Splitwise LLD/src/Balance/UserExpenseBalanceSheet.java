package Balance;

import User.User;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    Map<String, Balance> userBalanceMap;
    double totalExpense;
    double totalPayment;
    double totalOwe;
    double totalGetBack;

    public UserExpenseBalanceSheet() {
        userBalanceMap = new HashMap<>();
        totalExpense = 0;
        totalPayment = 0;
        totalOwe = 0;
        totalGetBack = 0;
    }

    public Map<String, Balance> getUserBalanceMap() {
        return userBalanceMap;
    }

    public void setUserBalanceMap(Map<String, Balance> userBalanceMap) {
        this.userBalanceMap = userBalanceMap;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }
}
