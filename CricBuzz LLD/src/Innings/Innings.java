package Innings;

import Match.MatchType;
import Team.Player.Player;
import Team.Team;

import java.util.ArrayList;
import java.util.List;

public class Innings {
    Team battingTeam;
    Team bowlingTeam;
    MatchType matchType;
    List<Over> overs;

    public Innings(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        overs = new ArrayList<>();
    }

    public void startInning(int runsToWin) {
        try {
            battingTeam.chooseNextBatsmen();
        } catch (Exception e) {
            return;
        }

        int noOfOvers = matchType.noOfOvers();
        for (int overNumber = 1; overNumber <= noOfOvers; overNumber++) {
            bowlingTeam.chooseNextBowler(matchType.maxOverCountPerBowler());
            Over over = new Over(overNumber, bowlingTeam.getCurrentBowler());
            overs.add(over);
            try {
                boolean won = over.startOver(battingTeam, bowlingTeam, runsToWin);
                if (won) break;
            } catch (Exception e) {
                break;
            }

            // swap striker and non striker after each over
            Player temp = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);
        }
    }

    public int getTotalRuns() {
        return battingTeam.getTotalRuns();
    }
}
