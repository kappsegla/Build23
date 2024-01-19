package org.example.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TennisGameTest {

    TennisGame tennisGame = new TennisGame();

    @Test
    void newGameShouldReturnLoveAll() {
        assertThat(tennisGame.getScore()).isEqualTo("Love-All");
    }

    @Test
    void playerOneWinsFirstBall() {
        tennisGame.updateFirstPlayerScore();
        assertThat(tennisGame.getScore()).isEqualTo("15-Love");
    }

    @Test
    void playerTwoWinsFirstBall() {
        tennisGame.updateSecondPlayerScore();
        assertThat(tennisGame.getScore()).isEqualTo("Love-15");
    }

    @Test
    void fiftteenAll() {
        tennisGame.updateFirstPlayerScore();
        tennisGame.updateSecondPlayerScore();
        assertThat(tennisGame.getScore()).isEqualTo("15-All");
    }

    @Test
    void fortyLove() {
        updateBothPlayerScoreNumberOfTimes(3,0);
        assertThat(tennisGame.getScore()).isEqualTo("40-Love");
    }

    @Test
    void deuce() {
        updateBothPlayerScoreNumberOfTimes(3,3);
        assertThat(tennisGame.getScore()).isEqualTo("Deuce");
        updateBothPlayerScoreNumberOfTimes(1,1);
        assertThat(tennisGame.getScore()).isEqualTo("Deuce");
        updateBothPlayerScoreNumberOfTimes(2,2);
        assertThat(tennisGame.getScore()).isEqualTo("Deuce");
    }

    @Test
    void playerOneWinsAfterDeuce() {
        updateBothPlayerScoreNumberOfTimes(6,4);
        assertThat(tennisGame.getScore()).isEqualTo("Player1 won the game");
    }


    @Test
    void playerOneWinsGame() {
        updateBothPlayerScoreNumberOfTimes(4,0);
        assertThat(tennisGame.getScore()).isEqualTo("Player1 won the game");
    }

    private void updateBothPlayerScoreNumberOfTimes(int firstPlayer, int secondPlayer){
        for(int i = 0; i<firstPlayer; i++){
            tennisGame.updateFirstPlayerScore();
        }
        for(int i = 0; i<secondPlayer; i++){
            tennisGame.updateSecondPlayerScore();
        }
    }
}
