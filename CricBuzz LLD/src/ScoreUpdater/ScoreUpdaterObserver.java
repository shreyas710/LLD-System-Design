package ScoreUpdater;

import Innings.Ball;

public interface ScoreUpdaterObserver {
    public void updateScore(Ball ball);
}
