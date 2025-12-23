// Program to check whether two texts are anagrams

import java.util.Scanner;

public class AnagramCheck {

    // Method to check if two texts are anagrams
    static boolean isAnagram(String text1, String text2) {

        // Check length
        if (text1.length() != text2.length()) {
            return false;
        }

        int[] freq1 = new int[256]; // ASCII frequency array
        int[] freq2 = new int[256];

        // Find frequency of characters in first text
        for (int i = 0; i < text1.length(); i++) {
            char ch = text1.charAt(i);
            freq1[ch]++;
        }

        // Find frequency of characters in second text
        for (int i = 0; i < text2.length(); i++) {
            char ch = text2.charAt(i);
            freq2[ch]++;
        }

        // Compare frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String text1 = in.nextLine();

        System.out.print("Enter second text: ");
        String text2 = in.nextLine();

        boolean result = isAnagram(text1, text2);

        if (result) {
            System.out.println("The given texts are anagrams");
        } else {
            System.out.println("The given texts are NOT anagrams");
        }

        in.close();
    }
}
