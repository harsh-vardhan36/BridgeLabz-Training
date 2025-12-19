//Program to Launch Rocket using For-loop.

import java.util.Scanner;

public class RocketLaunchCountdownUsingFor {
    public static void main(String[] args) {
        
        // Create a Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Ask the user to enter the starting number for the countdown
        System.out.print("Enter the countdown starting number: ");
        int start = input.nextInt();

        // Perform countdown using a for-loop
        for (int counter = start; counter >= 1; counter--) {
            System.out.println(counter);  // Print the current value
        }

        // Print final launch message
        System.out.println("Rocket Launch!");

        // Close the scanner
        input.close();
    }
}
