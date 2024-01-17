package org.example.roman;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    RomanNumeral romanNumeral = new RomanNumeral();

    @Test
    @DisplayName("Given I then returns 1")
    void givenIThenReturns1() {
       var result = romanNumeral.convert("I");

       assertEquals(1,result);
    }

    @DisplayName("Convert from Roman Numeral 🙄😎 to Decimal number system")
    @ParameterizedTest(name = "{index} ==> roman ''{0}'' is {1}")
    @CsvSource({
            "I, 1",
            "IV, 4",
            "V, 5",
            "IX, 9",
            "MM, 2000",
            "MX, 1010",
            "MXM, 1990"

    })
    void convertFromRomanToDecimal(String romanNumber, int expected) {
        var result = romanNumeral.convert(romanNumber);
        assertEquals(expected, result);
    }
    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8})
    void checkIfEven(int value){
        assertTrue(romanNumeral.isEven(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,5})
    void checkIfNotEven(int value){
        assertFalse(romanNumeral.isEven(value));
    }
}
