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



}
