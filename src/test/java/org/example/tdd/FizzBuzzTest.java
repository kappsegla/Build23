package org.example.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    //0,1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,...,14,FizzBuzz,...

    @Test
    @DisplayName("Given 0 then return 0")
    void given0ThenReturn0() {
        String result = FizzBuzz.convert(0);

        assertThat(result).isEqualTo("0");
    }

    @Test
    @DisplayName("Given 1 then return 1")
    void given1ThenReturn1() {
        assertThat(FizzBuzz.convert(1)).isEqualTo("1");
    }

    @Test
    @DisplayName("Given 3 then return Fizz")
    void given3ThenReturnFizz() {
        assertThat(FizzBuzz.convert(3)).isEqualTo("Fizz");
    }

    @Test
    @DisplayName("Given 6 then return Fizz")
    void given6ThenReturnFizz() {
        assertThat(FizzBuzz.convert(6)).isEqualTo("Fizz");
    }

    @Test
    @DisplayName("Given 5 return Buzz")
    void given5ReturnBuzz() {
        assertThat(FizzBuzz.convert(5)).isEqualTo("Buzz");
    }

}
