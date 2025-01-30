package org.example.kata;

public class Tennis {
    public String score(int player1Score, int player2Score) {
        if( player1Score == player2Score ){
            if( player1Score == 1)
                return "Fifteen - All";
            if( player1Score == 2)
                return "Thirty - All";
        }
        if( player1Score == 1)
            return "Fifteen - Love";

        return "Love - All";
    }
}
