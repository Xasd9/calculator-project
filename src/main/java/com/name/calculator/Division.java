package com.name.calculator;

public class Division implements Operation {
    @Override
    public double execute(double a, double b) {
        if (b == 0) {
            throw new CalculatorException("Деление на ноль невозможно");
        }
        return a / b;
    }
}
