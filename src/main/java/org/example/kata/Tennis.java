package org.example.kata;

import java.util.Map;

public class Tennis {

    public static final String ONE = "Love";

    enum Pretty {
        Love, Fifteen, Thirty, Forty, deuce
    }

    Map<Integer, String> pretty = Map.of(
            0, "Love",
            1, "Fifteen",
            2, "Thirty",
            3, "Forty",
            4, "Deuce");


    public String score(int player1Score, int player2Score) {

        if (player1Score == player2Score) {
            if (player1Score == 1)
                return "Fifteen - All";
            if (player1Score == 2)
                return "Thirty - All";
            if (player1Score > 2)
                return Pretty.deuce.toString();
        }
        if( player1Score > 3 && player1Score - player2Score >= 2) {
            return "Player one wins";
        }
        if( player1Score > 3 && player1Score - player2Score < 2) {
            return "Advantage player one";
        }
        if (player1Score > 0)
            return pretty.get(player1Score) + " - Love";
        return "Love - All";
    }
}
