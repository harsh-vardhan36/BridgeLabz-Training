// Program to check whether a text is a palindrome using different logics

import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Using start and end index comparison (loop)
    static boolean isPalindromeLogic1(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Using recursion
    static boolean isPalindromeLogic2(String text, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return isPalindromeLogic2(text, start + 1, end - 1);
    }

    // Method to reverse string using charAt()
    static char[] reverseString(String text) {

        char[] reverse = new char[text.length()];
        int index = 0;

        for (int i = text.length() - 1; i >= 0; i--) {
            reverse[index] = text.charAt(i);
            index++;
        }

        return reverse;
    }

    // Logic 3: Using character arrays
    static boolean isPalindromeLogic3(String text) {

        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = in.nextLine();

        boolean result1 = isPalindromeLogic1(text);
        boolean result2 = isPalindromeLogic2(text, 0, text.length() - 1);
        boolean result3 = isPalindromeLogic3(text);

        System.out.println("\nPalindrome Check Results:");
        System.out.println("Logic 1 (Loop)       : " + result1);
        System.out.println("Logic 2 (Recursion)  : " + result2);
        System.out.println("Logic 3 (Char Array) : " + result3);

        in.close();
    }
}
