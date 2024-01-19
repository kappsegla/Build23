package org.example.tdd;

public class TennisGame {
    private int firstPlayerScore;
    private int secondPlayerScore;

    public String getScore() {
        if(firstPlayerScore > 3 && firstPlayerScore-secondPlayerScore>=2 )
            return "Player1 won the game";

        if (firstPlayerScore == secondPlayerScore)
            return evenScore(firstPlayerScore);

        return translate(firstPlayerScore) + "-" + translate(secondPlayerScore);
    }

    private String translate(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> throw new IllegalStateException("Unexpected value: " + score);
        };
    }

    private String evenScore(int firstPlayerScore) {
        if(firstPlayerScore >= 3)
            return "Deuce";
        return translate(firstPlayerScore) + "-All";
    }

    public void updateFirstPlayerScore() {
        firstPlayerScore++;
    }

    public void updateSecondPlayerScore() {
        secondPlayerScore++;
    }
}
