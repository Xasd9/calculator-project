package com.name.calculator;

import java.util.ArrayList;

public class HistoryManager {

    private static final int MAX_SIZE = 10;
    private ArrayList<String> history = new ArrayList<>();
    private double lastA;
    private double lastB;
    private String lastOperator;
    private boolean hasLast = false;

    public void add(double a, String operator, double b, double result) {
        String record = a + " " + operator + " " + b + " = " + result;
        history.add(record);

        // Ограничиваем 10 элементами
        if (history.size() > MAX_SIZE) {
            history.remove(0);
        }

        // Запоминаем последнюю операцию
        lastA = a;
        lastB = b;
        lastOperator = operator;
        hasLast = true;
    }

    public ArrayList<String> getAll() {
        return history;
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public void clear() {
        history.clear();
        hasLast = false;
    }

    public boolean hasLast() {
        return hasLast;
    }

    public double getLastA() {
        return lastA;
    }

    public double getLastB() {
        return lastB;
    }

    public String getLastOperator() {
        return lastOperator;
    }
}