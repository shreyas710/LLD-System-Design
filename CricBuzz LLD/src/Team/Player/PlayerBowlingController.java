package Team.Player;

import java.util.*;

public class PlayerBowlingController {
    Deque<Player> bowlersList;
    Player currentBowler;
    Map<Player, Integer> bowlerToOverCount;

    public PlayerBowlingController(List<Player> bowlersList) {
        setBowlersList(bowlersList);
    }

    public void setBowlersList(List<Player> bowlersList) {
        this.bowlersList = new LinkedList<>();
        this.bowlerToOverCount = new HashMap<>();
        for (Player player : bowlersList) {
            this.bowlersList.add(player);
            this.bowlerToOverCount.put(player, 0);
        }
    }

    public void getNextBowler(int maxOverCountPerBowler) {
        Player player = bowlersList.poll();
        if (bowlerToOverCount.get(player) + 1 == maxOverCountPerBowler) {
            currentBowler = player;
        } else {
            currentBowler = player;
            bowlersList.addLast(player);
            bowlerToOverCount.put(player, bowlerToOverCount.get(player) + 1);
        }
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }
}
