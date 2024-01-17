package org.example.arrays;

import java.util.List;

public class Lists {

    List<Integer> removeNegativeNumbers(List<Integer> numbers) {
        boolean shouldBeFiltered = false;
        for (Integer number : numbers) {
            if (number < 0) {
                shouldBeFiltered = true;
                break;
            }
        }
        if( numbers.get(0).equals(0))
            throw new RuntimeException();
        if( shouldBeFiltered )
            return numbers.stream().filter(n -> n >= 0).sorted().toList();
        return numbers;
    }

    List<Integer> multiplyOddNumbersBy2(List<Integer> numbers) {
        return numbers.stream().map(n -> {
            if (n % 2 == 1) {
                return n * 2;
            }
            return n;
        }).toList();
    }

    List<Integer> createListWith3Numbers(){
        return List.of(1,2,3);
    }
}
