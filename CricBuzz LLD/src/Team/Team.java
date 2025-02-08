package Team;

import Team.Player.Player;
import Team.Player.PlayerBattingController;
import Team.Player.PlayerBowlingController;

import java.util.List;
import java.util.Queue;

public class Team {
    public String teamName;
    public Queue<Player> playing;
    public List<Player> substitutes;
    public PlayerBattingController battingController;
    public PlayerBowlingController bowlingController;
    public boolean isWinner;

    public Team(String teamName, Queue<Player> playing, List<Player> substitutes, List<Player> bowlers) {
        this.teamName = teamName;
        this.playing = playing;
        this.substitutes = substitutes;
        battingController = new PlayerBattingController(playing);
        bowlingController = new PlayerBowlingController(bowlers);
    }

    public String getTeamName() {
        return teamName;
    }

    public void chooseNextBatsmen() throws Exception {
        battingController.getNextPlayer();
    }

    public void chooseNextBowler(int maxOverCountPerBowler) {
        bowlingController.getNextBowler(maxOverCountPerBowler);
    }

    public Player getStriker() {
        return battingController.getStriker();
    }

    public Player getNonStriker() {
        return battingController.getNonStriker();
    }

    public void setStriker(Player player) {
        battingController.setStriker(player);
    }

    public void setNonStriker(Player player) {
        battingController.setNonStriker(player);
    }

    public Player getCurrentBowler() {
        return bowlingController.getCurrentBowler();
    }

    public void printBattingScoreCard() {
        for (Player player : playing) {
            player.printBattingScoreCard();
        }
    }

    public void printBowlingScoreCard() {
        for (Player player : playing) {
            if (player.bowlingScoreCard.totalOversCount > 0)
                player.printBowlingScoreCard();
        }
    }

    public int getTotalRuns() {
        int totalRuns = 0;
        for (Player player : playing) {
            totalRuns += player.battingScoreCard.totalRuns;
        }
        return totalRuns;
    }
}
