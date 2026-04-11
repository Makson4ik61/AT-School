package com.atschool;

import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Калькулятор")
@Feature("Арифметические операции")
class CalculatorTest {

    @Test
    @Story("Сложение")
    @Description("Проверка сложения двух чисел")
    void testAddition() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
        assertEquals(0, calc.add(-1, 1));
    }

    @Test
    @Story("Вычитание")
    @Description("Проверка вычитания двух чисел")
    void testSubtraction() {
        Calculator calc = new Calculator();
        assertEquals(7, calc.subtract(10, 3));
    }

    @Test
    @Story("Умножение")
    @Description("Проверка умножения двух чисел")
    void testMultiplication() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.multiply(3, 5));
    }

    @Test
    @Story("Деление")
    @Description("Проверка деления двух чисел и деления на ноль")
    void testDivision() {
        Calculator calc = new Calculator();
        assertEquals(4, calc.divide(20, 5));

        assertThrows(IllegalArgumentException.class,
                () -> calc.divide(10, 0));
    }
}