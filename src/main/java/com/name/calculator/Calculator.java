package com.name.calculator;

import java.util.HashMap;

public class Calculator {

    private final HashMap<String, Operation> operations = new HashMap<>();
    private final HistoryManager historyManager = new HistoryManager();

    public Calculator() {
        // Регистрируем все операции
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiplication());
        operations.put("/", new Division());
    }

    public double calculate(double a, double b, String operator) {
        Operation op = operations.get(operator);

        if (op == null) {
            throw new CalculatorException("Неизвестный оператор: " + operator);
        }

        double result = op.execute(a, b);
        historyManager.add(a, operator, b, result);
        return result;
    }

    public double repeatLast() {
        if (!historyManager.hasLast()) {
            throw new CalculatorException("Нет предыдущих операций");
        }
        return calculate(
                historyManager.getLastA(),
                historyManager.getLastB(),
                historyManager.getLastOperator()
        );
    }

    public HistoryManager getHistoryManager() {
        return historyManager;
    }
}