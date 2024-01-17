package org.example.variants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class ExamplesTest {

    @Test
    @DisplayName("Add returns sum of a and b")
    void addReturnsSumOfAAndB() {
        int a = 1;
        int b = 2;

        assertThat(Examples.add(a, b)).isEqualTo(3);
    }

    @Test
    @DisplayName("Add and return sums all calls")
    void addAndReturnSumsAllValues() {
        Examples examples = new Examples();
        var value1 = examples.addAndReturn(1);
        var value2 = examples.addAndReturn(3);
        assertThat(value1).isEqualTo(1);
        assertThat(value2).isEqualTo(4);
    }

    @Test
    @DisplayName("Add with one parameter adds value to internal state")
    void addWithOneParameterAddsValueToInternalState() {
        Examples examples = new Examples();
        examples.add(2);
        assertThat(examples.sum()).isEqualTo(2);
        examples.add(3);
        assertThat(examples.sum()).isEqualTo(5);
    }

    @Test
    @DisplayName("value method returns an integer from random object")
    void valueMethodReturnsAnIntegerFromRandomObject() {
        Examples examples = new Examples(new Random(1));

        //Expected value depends on what value was used as seed to Random constructor
        assertThat(examples.value()).isEqualTo(-1155869325);
    }

    @Test
    @DisplayName("Given a time before 12 when sayHello is called then says Good morning")
    void givenATimeBefore12WhenSayHelloIsCalledThenSaysGoodMorning() {
        Examples examples = new Examples();
        var hello = examples.sayHello(LocalTime.of(11, 0));

        assertThat(hello).isEqualTo("Good morning");
    }

    @Test
    @DisplayName("Given a time after 12 when sayHello is called then says Good afternoon")
    void givenATimeAfter12WhenSayHelloIsCalledThenSaysGoodAfternoon() {
        Examples examples = new Examples();
        var hello = examples.sayHello(LocalTime.of(14, 0));

        assertThat(hello).isEqualTo("Good afternoon");
    }
}
