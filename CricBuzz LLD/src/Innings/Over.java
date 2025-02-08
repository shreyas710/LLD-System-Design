package Innings;

import Team.Player.Player;
import Team.Team;

import java.util.ArrayList;
import java.util.List;

public class Over {
    int overNumber;
    List<Ball> balls;
    int extraBallsCount;
    Player bowledBy;

    Over(int overNumber, Player bowledBy) {
        this.overNumber = overNumber;
        this.bowledBy = bowledBy;
        balls = new ArrayList<>();
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin) throws Exception {
        int ballCount = 1;
        while (ballCount <= 6) {
            Ball ball = new Ball(ballCount);
            ball.startBallDelivery(battingTeam, bowlingTeam, this);
            if (ball.ballType == BallType.NORMAL) {
                balls.add(ball);
                ballCount++;
                if (ball.wicket != null) {
                    battingTeam.chooseNextBatsmen();
                }
                if (runsToWin != -1 && battingTeam.getTotalRuns() >= runsToWin) {
                    battingTeam.isWinner = true;
                    return true;
                }
            } else {
                extraBallsCount++;
            }
        }
        return false;
    }
}
