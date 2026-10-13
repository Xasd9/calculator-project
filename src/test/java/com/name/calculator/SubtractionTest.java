package com.name.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionTest {

    private final Subtraction subtraction = new Subtraction();

    @Test
    @DisplayName("10 - 3 = 7")
    void testPositiveNumbers() {
        assertEquals(7.0, subtraction.execute(10, 3));
    }

    @Test
    @DisplayName("3 - 10 = -7")
    void testNegativeResult() {
        assertEquals(-7.0, subtraction.execute(3, 10));
    }

    @Test
    @DisplayName("Вычитание нуля: 5 - 0 = 5")
    void testSubtractZero() {
        assertEquals(5.0, subtraction.execute(5, 0));
    }
}