// Program to find the frequency of characters in a string using charAt() method

import java.util.Scanner;

public class CharacterFrequency {

    // Method to find character frequency and return as 2D array
    static String[][] findFrequency(String text) {

        int[] freq = new int[256]; // ASCII characters

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Count unique characters
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] != 0) {
                count++;
                freq[ch] = -freq[ch]; // mark as visited
            }
        }

        String[][] result = new String[count][2];
        int index = 0;

        // Store characters and their frequencies
        for (int i = 0; i < 256; i++) {
            if (freq[i] < 0) {
                result[index][0] = String.valueOf((char) i);
                result[index][1] = String.valueOf(-freq[i]);
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

        String[][] frequencyData = findFrequency(text);

        System.out.println("\nCharacter\tFrequency");
        System.out.println("-----------------------");

        for (int i = 0; i < frequencyData.length; i++) {
            System.out.println(frequencyData[i][0] + "\t\t" + frequencyData[i][1]);
        }

        in.close();
    }
}
