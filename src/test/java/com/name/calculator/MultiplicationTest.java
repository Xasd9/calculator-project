package com.name.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {

    private final Multiplication multiplication = new Multiplication();

    @Test
    @DisplayName("4 * 6 = 24")
    void testPositiveNumbers() {
        assertEquals(24.0, multiplication.execute(4, 6));
    }

    @Test
    @DisplayName("Умножение на ноль: 5 * 0 = 0")
    void testMultiplyByZero() {
        assertEquals(0.0, multiplication.execute(5, 0));
    }

    @Test
    @DisplayName("Умножение отрицательных: -3 * -4 = 12")
    void testNegativeNumbers() {
        assertEquals(12.0, multiplication.execute(-3, -4));
    }

    @Test
    @DisplayName("Умножение дробных: 2.5 * 4 = 10.0")
    void testDecimals() {
        assertEquals(10.0, multiplication.execute(2.5, 4));
    }
}