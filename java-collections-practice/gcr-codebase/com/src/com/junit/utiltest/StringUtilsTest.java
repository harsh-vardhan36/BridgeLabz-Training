package com.junit.utiltest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    StringUtils utils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("olleh", utils.reverse("hello"));
    }

    @Test
    void testPalindromeTrue() {
        assertTrue(utils.isPalindrome("madam"));
    }

    @Test
    void testPalindromeFalse() {
        assertFalse(utils.isPalindrome("hello"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("JAVA", utils.toUpperCase("java"));
    }

    // Edge cases (very important)
    @Test
    void testNullInput() {
        assertNull(utils.reverse(null));
        assertFalse(utils.isPalindrome(null));
        assertNull(utils.toUpperCase(null));
    }
}
