package org.example.triangle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("Given two Point objects with same values should be equal")
    void givenTwoPointObjectsWithSameValuesShouldBeEqual() {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,1);

        assertEquals(p1, p2);
    }

    @Test
    @DisplayName("Creating Point with negative values throws exception")
    void creatingPointWithNegativeValuesThrowsException() {
        assertThrows(RuntimeException.class,()-> new Point(-1,0) );
    }


}
