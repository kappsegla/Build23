package org.example.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisTest {

    Tennis tennis = new Tennis();

    @Test
    @DisplayName("Both players have zero points")
    void bothPlayersHaveZeroPoints() {
        String score = tennis.score(0,0);
        assertThat(score).isEqualTo("Love - All");
    }

    @Test
    @DisplayName("Player one has 1 point and player two has 0 points")
    void playerOneHas1PointAndPlayerTwoHas0Points() {
        String score = tennis.score(1,0);
        assertThat(score).isEqualTo("Fifteen - Love");
    }

}
