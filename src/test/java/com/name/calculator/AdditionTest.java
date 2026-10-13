package com.name.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {

    private final Addition addition = new Addition();

    @Test
    @DisplayName("5 + 3 = 8")
    void testPositiveNumbers() {
        assertEquals(8.0, addition.execute(5, 3));
    }

    @Test
    @DisplayName("Сложение с отрицательным: -5 + 3 = -2")
    void testNegativeNumber() {
        assertEquals(-2.0, addition.execute(-5, 3));
    }

    @Test
    @DisplayName("Сложение с нулём: 0 + 7 = 7")
    void testWithZero() {
        assertEquals(7.0, addition.execute(0, 7));
    }

    @Test
    @DisplayName("Сложение дробных: 2.5 + 3.5 = 6.0")
    void testDecimals() {
        assertEquals(6.0, addition.execute(2.5, 3.5));
    }
}