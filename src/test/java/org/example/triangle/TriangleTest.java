package org.example.triangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TriangleTest {

    @Test
    void isScalene_AllSidesDifferent_ReturnsTrue() {
        // Arrange
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);

        // Act
        boolean result = triangle.isScalene();

        // Assert
        assertTrue(result, "Triangle with all different sides should be scalene");
    }

    @Test
    void isScalene_TwoSidesEqual_ReturnsFalse() {
        Triangle triangle = new Triangle(3.0, 3.0, 4.0);

        assertFalse(triangle.isScalene(), "Triangle with two equal sides should not be scalene");
    }

    @Test
    void isScalene_AllSidesEqual_ReturnsFalse() {
        Triangle triangle = new Triangle(2.0, 2.0, 2.0);

        assertFalse(triangle.isScalene(), "Triangle with all equal sides should not be scalene");
    }

    @Test
    void isEquilateral_AllSidesEqual_ReturnsTrue() {
        Triangle triangle = new Triangle(2.0, 2.0, 2.0);

        boolean result = triangle.isEquilateral();

        assertTrue(result, "Triangle with all equal sides should be equilateral");
    }

    @Test
    void isEquilateral_TwoSidesEqual_ReturnsFalse() {
        Triangle triangle = new Triangle(2.0, 2.0, 3.0);

        boolean result = triangle.isEquilateral();

        assertFalse(result, "Triangle with two equal sides should not be equilateral");
    }

    @Test
    void isEquilateral_AllSidesDifferent_ReturnsFalse() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);

        boolean result = triangle.isEquilateral();

        assertFalse(result, "Triangle with all different sides should not be equilateral");
    }

    @Test
    void isIsosceles_TwoSidesEqual_ReturnsTrue() {
        Triangle triangle = new Triangle(2.0, 2.0, 3.0);

        boolean result = triangle.isIsosceles();

        assertTrue(result, "Triangle with exactly two equal sides should be isosceles");
    }

    @Test
    void isIsosceles_AllSidesEqual_ReturnsFalse() {
        Triangle triangle = new Triangle(2.0, 2.0, 2.0);

        boolean result = triangle.isIsosceles();

        assertFalse(result, "Triangle with all equal sides should not be isosceles");
    }

    @Test
    void isIsosceles_AllSidesDifferent_ReturnsFalse() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);

        boolean result = triangle.isIsosceles();

        assertFalse(result, "Triangle with all different sides should not be isosceles");
    }

    @Test
    void constructTriangleFromPoints_ScaleneTriangle_CorrectlyClassified() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        Point c = new Point(4, 0);
        Triangle triangle = new Triangle(a, b, c);

        boolean result = triangle.isScalene();

        assertTrue(result, "Triangle constructed from points should be correctly classified as scalene");
    }
}
