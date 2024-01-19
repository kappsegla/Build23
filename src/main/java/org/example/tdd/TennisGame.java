package org.example.tdd;

public class TennisGame {
    private int firstPlayerScore;
    private int secondPlayerScore;

    public String getScore() {
        if (firstPlayerScore == 1)
            return "15-Love";
        if (secondPlayerScore == 1)
            return "Love-15";
        return "Love-All";
    }

    public void updateFirstPlayerScore() {
        firstPlayerScore++;
    }

    public void updateSecondPlayerScore() {
        secondPlayerScore++;
    }
}
