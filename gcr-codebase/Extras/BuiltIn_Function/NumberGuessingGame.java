// Program: Number Guessing Game, take feedback, and next guess number.

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Method to generate a random guess between min and max
    public static int generateGuess(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    // Method to get user feedback
    public static String getFeedback(Scanner in, int guess) {
        System.out.print("Is the number " + guess + "? (Enter 'high', 'low', or 'correct'): ");
        return in.nextLine().toLowerCase();
    }

    // Method to adjust range based on feedback
    public static int[] adjustRange(int min, int max, int guess, String feedback) {
        if (feedback.equals("high")) {
            max = guess - 1; 
        } else if (feedback.equals("low")) {
            min = guess + 1; 
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");

        int min = 1, max = 100;
        boolean found = false;

        while (!found && min <= max) {
            int guess = generateGuess(min, max);
            String feedback = getFeedback(in, guess);

            if (feedback.equals("correct")) {
                System.out.println("Yay! I guessed your number: " + guess);
                found = true;
            } else {
                int[] range = adjustRange(min, max, guess, feedback);
                min = range[0];
                max = range[1];
            }
        }

        if (!found) {
            System.out.println("Sorry! please try again.");
        }

        in.close();
    }
}
