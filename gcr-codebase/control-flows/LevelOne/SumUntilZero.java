// A program to calculate the sum of numbers entered by the user
// The loop continues until the user enters 0.

import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        
        // Create a Scanner object to read input
        Scanner input = new Scanner(System.in);

        // Variable to store the total sum
        double total = 0.0;

        // Variable to store the user input
        double number;

        // Ask the user for the first number
        System.out.print("Enter a number (0 to stop): ");
        number = input.nextDouble();

        // Continue until the user enters 0
        while (number != 0) {
            total += number;  // Add the number to the total
            System.out.print("Enter a number (0 to stop): ");
            number = input.nextDouble();  // Read the next number
        }

        // Display the total sum after the loop ends
        System.out.println("The total sum is: " + total);

        // Close the scanner
        input.close();
    }
}
