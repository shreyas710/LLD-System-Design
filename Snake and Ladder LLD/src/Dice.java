import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int roll() {
        int total = 0;
        for (int i = 0; i < this.diceCount; i++) {
            total += ThreadLocalRandom.current().nextInt(1, 6);
        }
        System.out.println("dice rolled: " + total);
        return total;
    }
}
