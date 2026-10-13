package com.name.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryManagerTest {

    private HistoryManager historyManager;

    @BeforeEach
    void setUp() {
        historyManager = new HistoryManager();
    }

    @Test
    @DisplayName("Новая история пуста")
    void testEmptyAtStart() {
        assertTrue(historyManager.isEmpty());
        assertEquals(0, historyManager.getAll().size());
    }

    @Test
    @DisplayName("Добавление операции сохраняет её")
    void testAddOperation() {
        historyManager.add(5.0, "+", 3.0, 8.0);

        assertEquals(1, historyManager.getAll().size());
        assertEquals("5.0 + 3.0 = 8.0", historyManager.getAll().get(0));
    }

    @Test
    @DisplayName("Ограничение размера 10 элементами")
    void testMaxSize() {
        for (int i = 1; i <= 15; i++) {
            historyManager.add(i, "+", 1, i + 1);
        }

        assertEquals(10, historyManager.getAll().size());
        // первый элемент — 6-я операция (1-5 удалены)
        assertEquals("6.0 + 1.0 = 7.0", historyManager.getAll().get(0));
    }

    @Test
    @DisplayName("Очистка истории")
    void testClear() {
        historyManager.add(5.0, "+", 3.0, 8.0);
        historyManager.clear();

        assertTrue(historyManager.isEmpty());
    }

    @Test
    @DisplayName("Сохранение последней операции")
    void testHasLast() {
        assertFalse(historyManager.hasLast());

        historyManager.add(5.0, "*", 3.0, 15.0);

        assertTrue(historyManager.hasLast());
        assertEquals(5.0, historyManager.getLastA());
        assertEquals(3.0, historyManager.getLastB());
        assertEquals("*", historyManager.getLastOperator());
    }
}