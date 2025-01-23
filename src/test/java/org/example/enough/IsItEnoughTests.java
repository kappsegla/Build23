package org.example.enough;

import net.jqwik.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class IsItEnoughTests {

    @Property
    void testIsItEnough(@ForAll("greatValues") int i) {
        String greeting = WhenIsItEnough.greeting(i);
        assertThat(greeting).isEqualTo("A great value");
    }

    @Provide
    Arbitrary<Integer> greatValues() {
        return Arbitraries.integers().between(0, 100);
    }


}
