package org.example;

public class GameResult {
    public boolean solved;
    public int strike;
    public int balls;

    public GameResult(boolean solved, int strike, int balls) {
        this.solved = solved;
        this.strike = strike;
        this.balls = balls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof GameResult) {
            return ((GameResult) o).solved == solved && ((GameResult) o).strike == strike && ((GameResult) o).balls == this.balls;
        }
        return false;

    }
}
