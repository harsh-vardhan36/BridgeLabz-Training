// Program to find the first non-repeating character in a string

import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Method to find first non-repeating character using charAt()
    static char findFirstNonRepeatingChar(String text) {

        int[] frequency = new int[256]; // ASCII characters

        // Loop to count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Loop to find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // if no non-repeating character found
    }

    // Main method
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = in.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result != '\0') {
            System.out.println("First non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found");
        }

        in.close();
    }
}
