package org.example.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TennisGameTest {

    @Test
    void first() {
    TennisGame tennisGame = new TennisGame();
    assertThat(tennisGame.getScore()).isEqualTo("Love-All");
    }

}
