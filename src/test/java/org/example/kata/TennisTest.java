package org.example.kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisTest {

    Tennis tennis = new Tennis();

    @ParameterizedTest
    @CsvSource({
            "0, 0, 'Love - All'",
            "1, 1, 'Fifteen - All'",
            "2, 2, 'Thirty - All'",
            "3, 3, 'deuce'",
            "4, 4, 'deuce'",
            "1, 0, 'Fifteen - Love'"
    })
    void tennisScore(int playerOneScore, int playerTwoScore, String expectedMessage) {
        assertThat(tennis.score(playerOneScore, playerTwoScore)).isEqualTo(expectedMessage);
    }

}
