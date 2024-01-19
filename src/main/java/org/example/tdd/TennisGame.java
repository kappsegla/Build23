package org.example.tdd;

public class TennisGame {
    private int firstPlayerScore;
    public String getScore() {
        if(firstPlayerScore == 1)
            return "15-Love";
        return "Love-All";
    }

    public void updateFirstPlayerScore() {
        firstPlayerScore++;
    }
}
