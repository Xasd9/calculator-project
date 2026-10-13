package com.name.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    private final Division division = new Division();

    @Test
    @DisplayName("10 / 2 = 5")
    void testEvenDivision() {
        assertEquals(5.0, division.execute(10, 2));
    }

    @Test
    @DisplayName("5 / 2 = 2.5")
    void testDecimalResult() {
        assertEquals(2.5, division.execute(5, 2));
    }

    @Test
    @DisplayName("Деление на ноль выбрасывает исключение")
    void testDivisionByZero() {
        CalculatorException exception = assertThrows(
                CalculatorException.class,
                () -> division.execute(10, 0)
        );
        assertEquals("Деление на ноль невозможно", exception.getMessage());
    }

    @Test
    @DisplayName("Деление нуля: 0 / 5 = 0")
    void testZeroDivided() {
        assertEquals(0.0, division.execute(0, 5));
    }
}