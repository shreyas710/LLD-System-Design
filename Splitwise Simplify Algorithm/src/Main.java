import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private int dfs(List<Integer> balances, int currIndex) {
        if (currIndex >= balances.size()) {
            return 0;
        }
        if (balances.get(currIndex) == 0) {
            return dfs(balances, currIndex + 1);
        }
        int currVal = balances.get(currIndex);
        int minTransactionCount = Integer.MAX_VALUE;

        for (int i = currIndex + 1; i < balances.size(); i++) {
            int nextVal = balances.get(i);
            if (currVal * nextVal < 0) {
                balances.set(i, currVal + nextVal);
                minTransactionCount = Math.min(minTransactionCount, 1 + dfs(balances, currIndex + 1));
                balances.set(i, nextVal);

                if (currVal + nextVal == 0) break;
            }
        }
        return minTransactionCount;
    }

    public int minTransfers(int[][] transactions) {
        // compute balance = incoming - outgoing
        Map<Integer, Integer> nodeBalance = new HashMap<>();
        for (int [] transaction : transactions) {
            int from = transaction[0];
            int to = transaction[1];
            int amount = transaction[2];
            nodeBalance.put(from, nodeBalance.getOrDefault(from, 0) - amount);
            nodeBalance.put(to, nodeBalance.getOrDefault(to, 0) + amount);
        }

        // balance list
        List<Integer> balances = new ArrayList<>();
        for (int amount : nodeBalance.values()) {
            if (amount != 0) {
                balances.add(amount);
            }
        }

        // call dfs
        return dfs(balances, 0);
    }

    public static void main(String[] args) {

    }
}