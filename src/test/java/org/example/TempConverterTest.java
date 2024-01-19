package org.example;

import org.assertj.core.data.Offset;
import org.example.tdd.TempConv;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TempConverterTest {

    @Test
    @DisplayName("Parse single value")
    void parseSingleValue() {
       float result = TempConv.convert("22.7");
       assertThat(result).isEqualTo(22.7f);
    }

    @Test
    @DisplayName("Parse single value with prefix of Place")
    void parseSingleValueWithPrefixOfPlace() {
        float result = TempConv.convert("Göteborg,22.4");
        assertThat(result).isEqualTo(22.4f);
    }

    @Test
    @DisplayName("Parse single value with Temp: prefix")
    void parseSingleValueWithTempPrefix() {
        float result = TempConv.convert("Time: 20:29, Date: 16 May 2007, Temp: 12.23°C");
        assertThat(result).isEqualTo(12.23f);
    }

    @Test
    @DisplayName("Parse single value with Fahrenheit")
    void parseSingleValueWithFahrenheit() {
        float result = TempConv.convert("Time: 20:29, Date: 16 May 2007, Temp: 75°F");
        assertThat(result).isCloseTo(23.88f, Offset.offset(0.01f));
    }
}
