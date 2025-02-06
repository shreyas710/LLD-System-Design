package Expense;

import Expense.Split.*;

public class SplitFactory {
    public static ExpenseSplit getSplit(ExpenseSplitType type) {
        return switch (type) {
            case EQUAL -> new EqualExpenseSplit();
            case UNEQUAL -> new UnequalExpenseSplit();
            case PERCENTAGE -> new PercentageExpenseSplit();
            default -> null;
        };
    }
}
