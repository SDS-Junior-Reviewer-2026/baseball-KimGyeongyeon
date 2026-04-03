package org.example;

public class GameResult {
    private boolean solved;
    private int strike;
    private int balls;

    public GameResult(boolean solved, int strike, int balls) {
        this.solved = solved;
        this.strike = strike;
        this.balls = balls;
    }

    static GameResult solved(int length) {
        return new GameResult(true, length, 0);
    }

    static GameResult unSolved(int strike, int balls) {
        return new GameResult(false, strike, balls);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GameResult) {
            return ((GameResult) o).solved == solved && ((GameResult) o).strike == strike && ((GameResult) o).balls == this.balls;
        }
        return false;

    }

    public boolean isSolved() {
        return solved;
    }

    public int getStrike() {
        return strike;
    }

    public int getBalls() {
        return balls;
    }
}
