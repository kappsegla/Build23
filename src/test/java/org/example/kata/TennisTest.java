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
            "1, 0, 'Fifteen - Love'",
            "2, 0, 'Thirty - Love'",
            "3, 0, 'Forty - Love'",
            "4, 0, 'Player one wins'",
            "4, 1, 'Player one wins'",
            "4, 2, 'Player one wins'",
            "4, 3, 'Advantage player one'",
            "5, 4, 'Advantage player one'",
            "6, 4, 'Player one wins'"
    })
    void tennisScore(int playerOneScore, int playerTwoScore, String expectedMessage) {
        assertThat(tennis.score(playerOneScore, playerTwoScore)).isEqualTo(expectedMessage);
    }

}
