// A simple program to perform a countdown for a rocket launch
// It takes a number from the user and counts down to 1 using a while loop.

import java.util.Scanner;

public class RocketLaunchCountdown {
    public static void main(String[] args) {
        
        // Create a Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Ask the user to enter the starting number for the countdown
        System.out.print("Enter the countdown starting number: ");
        int counter = input.nextInt();

        // Perform countdown using a while loop
        while (counter >= 1) {
            System.out.println(counter);  // Print the current value
            counter--;                    // Decrement the counter by 1
        }

        // Print final launch message
        System.out.println("Rocket Launch! ");

        // Close the scanner
        input.close();
    }
}
