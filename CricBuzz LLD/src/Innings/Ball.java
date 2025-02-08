package Innings;

import ScoreUpdater.BattingScoreUpdater;
import ScoreUpdater.BowlingScoreUpdater;
import ScoreUpdater.ScoreUpdaterObserver;
import Team.Player.Player;
import Team.Team;
import Team.Wicket.Wicket;
import Team.Wicket.WicketType;

import java.util.ArrayList;
import java.util.List;

public class Ball {
    public int ballNumber;
    public BallType ballType;
    public RunType runType;
    public Player playedBy;
    public Player bowledBy;
    public Wicket wicket;
    List<ScoreUpdaterObserver> scoreUpdaterObservers = new ArrayList<>();

    public Ball(int ballNumber) {
        this.ballNumber = ballNumber;
        scoreUpdaterObservers.add(new BattingScoreUpdater());
        scoreUpdaterObservers.add(new BowlingScoreUpdater());
    }

    public void startBallDelivery(Team battingTeam, Team bowlingTeam, Over over) {
        playedBy = battingTeam.getStriker();
        this.bowledBy = over.bowledBy;

        // throw ball and get ball type
        ballType = BallType.NORMAL;

        // wicket or no wicket
        if (isWicketTaken()) {
            runType = RunType.ZERO;

            // considering only BOLD Wicket
            wicket = new Wicket(WicketType.BOLD, bowlingTeam.getCurrentBowler(), over, this);

            // making striker out
            battingTeam.setStriker(null);
        } else {
            runType = getRunType();

            if (runType == RunType.ONE || runType == RunType.THREE) {
                // swap striker and non striker
                Player temp = battingTeam.getStriker();
                battingTeam.setStriker(battingTeam.getNonStriker());
                bowlingTeam.setNonStriker(temp);
            }
        }
        notifyUpdaters(this);
    }

    public void notifyUpdaters(Ball ball) {
        for (ScoreUpdaterObserver scoreUpdaterObserver : scoreUpdaterObservers) {
            scoreUpdaterObserver.updateScore(ball);
        }
    }

    private RunType getRunType() {
        double val = Math.random();
        if (val <= 0.2) {
            return RunType.ONE;
        } else if (val >= 0.3 && val <= 0.5) {
            return RunType.TWO;
        } else if (val >= 0.6 && val <= 0.8) {
            return RunType.FOUR;
        } else {
            return RunType.SIX;
        }
    }

    private boolean isWicketTaken() {
        if (Math.random() < 0.2) {
            return true;
        } else {
            return false;
        }
    }
}
