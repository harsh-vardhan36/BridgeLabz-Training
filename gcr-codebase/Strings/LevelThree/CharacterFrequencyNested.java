// Program to find the frequency of characters in a string using nested loops

import java.util.Scanner;

public class CharacterFrequencyNested {

    // Method to find frequency using nested loops and return as 1D array
    static String[] findFrequency(String text) {

        char[] chars = text.toCharArray();   // store characters
        int[] freq = new int[chars.length]; // store frequency

        // Initialize frequency array
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
        }

        // Nested loop to calculate frequency
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '0')
                continue;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        // Count unique characters
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        // Create result array
        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " : " + freq[i];
                index++;
            }
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = in.nextLine();

        String[] result = findFrequency(text);

        System.out.println("\nCharacter Frequency:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        in.close();
    }
}
