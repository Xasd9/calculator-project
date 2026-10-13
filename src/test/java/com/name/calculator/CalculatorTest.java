package com.name.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Сложение: 5 + 3 = 8")
    void testAddition() {
        assertEquals(8.0, calculator.calculate(5, 3, "+"));
    }

    @Test
    @DisplayName("Вычитание: 10 - 3 = 7")
    void testSubtraction() {
        assertEquals(7.0, calculator.calculate(10, 3, "-"));
    }

    @Test
    @DisplayName("Умножение: 4 * 6 = 24")
    void testMultiplication() {
        assertEquals(24.0, calculator.calculate(4, 6, "*"));
    }

    @Test
    @DisplayName("Деление: 5 / 2 = 2.5")
    void testDivision() {
        assertEquals(2.5, calculator.calculate(5, 2, "/"));
    }

    @Test
    @DisplayName("Деление на ноль выбрасывает исключение")
    void testDivisionByZero() {
        CalculatorException exception = assertThrows(
                CalculatorException.class,
                () -> calculator.calculate(10, 0, "/")
        );
        assertEquals("Деление на ноль невозможно", exception.getMessage());
    }

    @Test
    @DisplayName("Неизвестный оператор выбрасывает исключение")
    void testUnknownOperator() {
        assertThrows(
                CalculatorException.class,
                () -> calculator.calculate(5, 3, "%")
        );
    }
}