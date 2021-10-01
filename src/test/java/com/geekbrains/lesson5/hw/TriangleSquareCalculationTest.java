package com.geekbrains.lesson5.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.geekbrains.lesson5.hw.Triangle.calculateTriangleSquare;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class TriangleSquareCalculationTest {
    @Test
    void positiveSquareCalcTest() throws Exception {
        double result = calculateTriangleSquare(2, 2, 2);
        Assertions.assertEquals(3, result);
    }

    @Test
    void negativeSquareCalcTest() {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> calculateTriangleSquare(-2, 2, 2));
    }
}
