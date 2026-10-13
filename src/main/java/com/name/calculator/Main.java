package com.name.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Calculator calculator = new Calculator();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printWelcome();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("До свидания!");
                break;
            }

            if (input.isEmpty()) {
                System.out.println("Ошибка! Введите выражение.");
                continue;
            }

            // === КОМАНДЫ ===
            if (input.equalsIgnoreCase("history")) {
                showHistory();
                continue;
            }

            if (input.equalsIgnoreCase("clear")) {
                calculator.getHistoryManager().clear();
                System.out.println("История очищена");
                continue;
            }

            if (input.equalsIgnoreCase("last")) {
                repeatLast();
                continue;
            }

            if (input.equalsIgnoreCase("help")) {
                showHelp();
                continue;
            }

            // === ВЫЧИСЛЕНИЕ ===
            processInput(input);
        }

        scanner.close();
    }

    private static void printWelcome() {
        System.out.println("Введите выражение (например, 5 + 3)");
        System.out.println("Введите 'help' для списка команд");
        System.out.println();
    }

    private static void showHistory() {
        ArrayList<String> history = calculator.getHistoryManager().getAll();

        if (history.isEmpty()) {
            System.out.println("История пуста");
        } else {
            System.out.println("История операций:");
            for (int i = 0; i < history.size(); i++) {
                System.out.println("  " + (i + 1) + ") " + history.get(i));
            }
        }
    }

    private static void repeatLast() {
        try {
            double result = calculator.repeatLast();
            System.out.println("Результат: " + result);
        } catch (CalculatorException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void showHelp() {
        System.out.println("Доступные команды:");
        System.out.println("  <число> <оператор> <число>  — вычислить");
        System.out.println("  history  — показать историю");
        System.out.println("  last     — повторить последнюю операцию");
        System.out.println("  clear    — очистить историю");
        System.out.println("  help     — показать эту справку");
        System.out.println("  exit     — выйти");
    }

    private static void processInput(String input) {
        try {
            String[] parts = input.split(" ");

            if (parts.length != 3) {
                System.out.println("Ошибка! Введите: число оператор число (например, 5 + 3)");
                return;
            }

            double num1 = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double num2 = Double.parseDouble(parts[2]);

            double result = calculator.calculate(num1, num2, operator);
            System.out.println("Результат: " + num1 + " " + operator + " " + num2 + " = " + result);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Введите числа, а не текст.");
        } catch (CalculatorException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}