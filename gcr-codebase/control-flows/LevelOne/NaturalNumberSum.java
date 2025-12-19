// A program to check if a given number is a natural number
// and calculate the sum of n natural numbers using the formula n*(n+1)/2.

import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        
        // Create a Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Check if the number is a natural number (positive integer, including 0 if considered)
        if (number >= 0) {
            // Calculate the sum of n natural numbers using the formula
            int sum = number * (number + 1) / 2;
            System.out.println("The sum of " + number + " natural numbers is " + sum);
        } else {
            // If the number is negative, it is not a natural number
            System.out.println("The number " + number + " is not a natural number");
        }
        input.close();
    }
}
