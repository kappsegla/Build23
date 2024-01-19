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


}
