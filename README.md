# Calculator Project

Консольный калькулятор на Java с поддержкой истории вычислений.

## Возможности

- ✅ Операции: `+`, `-`, `*`, `/`
- ✅ Работа с дробными числами (`double`)
- ✅ История последних 10 операций
- ✅ Команды: `history`, `last`, `clear`, `help`, `exit`
- ✅ Обработка ошибок (деление на ноль, некорректный ввод)

## Технологии

- Java 23
- Maven
- JUnit 5

## Архитектура

- `Main` — ввод/вывод
- `Calculator` — вычисления
- `HistoryManager` — история
- `Operation` + 4 класса операций — паттерн Strategy
- `CalculatorException` — своё исключение

## Как запустить

### Через IntelliJ IDEA
1. Открой проект
2. Запусти `Main.java`

### Через Maven
```bash
mvn clean package
java -jar target/calculator-1.0-SNAPSHOT.jar
