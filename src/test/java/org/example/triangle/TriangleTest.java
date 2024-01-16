package org.example.triangle;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    @DisplayName("Given triangle with 3 different sides when calling isScalene then return true")
    void givenScaleneTriangle_whenIsScalene_thenReturnTrue(){
        Triangle triangle = new Triangle(1,2,3);

        var result = triangle.isScalene();

        //assertEquals(true, result,"Scalene triangle should return true");
        //assertTrue(result, "Scalene triangle with sides of " + Arrays.toString(triangle.sides) + " should return true");
        assertTrue(result,()->"Scalene triangle with sides of " + Arrays.toString(triangle.sides) + " should return true");
    }

    @Test
    @DisplayName("Given a triangle with 3 equal sides, isScalene returns false")
    void givenATriangleWith3EqualSidesIsScaleneReturnsFalse() {
        Triangle triangle = new Triangle(2,2,2);

        var result = triangle.isScalene();

        assertFalse(result);
    }

    @Test
    @DisplayName("Given a triangle with 2 equal sides, isEquilateral returns false")
    void givenATriangleWith2EqualSidesIsEquilateralReturnsFalse() {
        Triangle triangle = new Triangle(1,2,2);

        var result = triangle.isEquilateral();

        assertFalse(result);
    }



}
