package com.junit.exceptiontest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

    MathUtils utils = new MathUtils();

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> {
            utils.divide(10, 0);
        });
    }

    @Test
    void testDivideValidInput() {
        assertEquals(5, utils.divide(10, 2));
    }
}
