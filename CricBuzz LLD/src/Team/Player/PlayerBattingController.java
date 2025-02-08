package Team.Player;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerBattingController {
    Queue<Player> yetToBat;
    Player striker;
    Player nonStriker;

    public PlayerBattingController(Queue<Player> yetToBat) {
        this.yetToBat = new LinkedList<>();
        this.yetToBat.addAll(yetToBat);
    }

    public void getNextPlayer() throws Exception {
        if (yetToBat.isEmpty()) {
            throw new Exception();
        }
        if (striker == null) {
            striker = yetToBat.poll();
        }
        if (nonStriker == null) {
            nonStriker = yetToBat.poll();
        }
    }

    public Player getStriker() {
        return striker;
    }

    public void setStriker(Player striker) {
        this.striker = striker;
    }

    public Player getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(Player nonStriker) {
        this.nonStriker = nonStriker;
    }
}
