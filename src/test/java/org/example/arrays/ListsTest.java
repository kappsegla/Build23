package org.example.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ListsTest {

    @Test
    @DisplayName("Given a list with negative and positive numbers when calling remove negative numbers then return list with only positive numbers")
    void givenAListWithNegativeNumbersWhenCallingRemoveNegativeNumbersThenReturnListWithOnlyPositiveNumbers() {
        //Given - Arrange
        List<Integer> values = List.of(1, -1, 0, -100, 10);
        List<Integer> expected = List.of(1, 0, 10);
        Lists lists = new Lists();

        //When - Act
        var result = lists.removeNegativeNumbers(values);

        //Then - Assert
        assertThat(result)
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    @DisplayName("Only positive numbers returns same list content")
    void onlyPositiveNumbersReturnsSameListContent() {
        List<Integer> values = List.of(1,2,3);
        Lists lists = new Lists();

        var result = lists.removeNegativeNumbers(values);

        assertThat(result).containsExactlyInAnyOrder(1,2,3);
    }


}
