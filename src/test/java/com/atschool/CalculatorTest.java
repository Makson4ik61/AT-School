package com.atschool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
        assertEquals(0, calc.add(-1, 1));
    }

    @Test
    void testSubtraction() {
        Calculator calc = new Calculator();
        assertEquals(7, calc.subtract(10, 3));
    }

    @Test
    void testMultiplication() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.multiply(3, 5));
    }

    @Test
    void testDivision() {
        Calculator calc = new Calculator();
        assertEquals(4, calc.divide(20, 5));

        assertThrows(IllegalArgumentException.class,
                () -> calc.divide(10, 0));
    }
}