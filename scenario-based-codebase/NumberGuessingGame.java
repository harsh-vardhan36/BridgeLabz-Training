import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numberToGuess = rand.nextInt(100) + 1; // random number 1-100
        int attempts = 0;
        int guess;

        System.out.println(" Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100.");

        do {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                System.out.println(" Correct! You guessed the number in " + attempts + " attempts.");
                break;
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }

            if (attempts == 5) {
                System.out.println("Game Over! You've used all 5 attempts.");
                System.out.println("The correct number was: " + numberToGuess);
                break;
            }

        } while (true);

        sc.close();
    }
}
