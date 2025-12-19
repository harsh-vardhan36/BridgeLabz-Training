//  program to calculate the sum of numbers entered by the user
// The loop continues until the user enters 0 or a negative number.
// Uses an infinite while loop with break statement.

import java.util.Scanner;

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        
        // Create a Scanner object to read input
        Scanner input = new Scanner(System.in);

        // Variable to store the total sum
        double total = 0.0;

        // Infinite loop to keep asking for numbers
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double number = input.nextDouble();

            // Check if the number is 0 or negative → break the loop
            if (number <= 0) {
                break;
            }

            // Add the number to the total
            total += number;
        }

        // Display the total sum after the loop ends
        System.out.println("The total sum is: " + total);

        // Close the scanner
        input.close();
    }
}
