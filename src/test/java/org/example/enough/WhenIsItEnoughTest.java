package org.example.enough;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WhenIsItEnoughTest {

    @Test
    @DisplayName("Less than 0 is invalid")
    void lessThan0IsInvalid() {
        assertThat(WhenIsItEnough.greeting(-1)).isEqualTo("Invalid value");
    }

    @Test
    @DisplayName("More than 100 is invalid")
    void moreThan100IsInvalid() {
        assertThat(WhenIsItEnough.greeting(101)).isEqualTo("Invalid value");
    }

    @Test
    @DisplayName("Number 0 is a great value")
    void number0IsAGreatValue() {
        assertThat(WhenIsItEnough.greeting(0)).isEqualTo("A great value");
    }

    @Test
    @DisplayName("Number 100 is a great value")
    void number100IsAGreatValue() {
        assertThat(WhenIsItEnough.greeting(100)).isEqualTo("A great value");
    }

    @Tag("Enhanced")
    @ParameterizedTest
    @MethodSource(value = "greatValues")
    void greatValue(int value) {
        assertThat(WhenIsItEnough.greeting(value)).isEqualTo("A great value");
    }

    static Stream<Integer> greatValues() {
        return Stream.iterate(0, i -> i + 1).limit(101);
    }


    @Test
    @DisplayName("Invalid email throws exception")
    void invalidEmailThrowsException() {
        //Junit5 API style
        var exception = assertThrows(IllegalArgumentException.class, () -> WhenIsItEnough.setAdminEmail("invalid#email.com"));
        assertEquals("Invalid email format", exception.getMessage());
        //AssertJ style
        assertThatThrownBy(() -> WhenIsItEnough.setAdminEmail("invalid#email.com"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid email format");
    }
}
