
//Program to Check if "age >= 18" of user.

import java.util.Scanner;

public class VotingCheck {
    public static void main(String[] args) {
        
        // Create a Scanner object to read input
        Scanner input = new Scanner(System.in);

        // Ask the user for their age
        System.out.print("Enter your age: ");
        int age = input.nextInt();

        // Check if age is 18 or more
        if (age >= 18) {
            System.out.println("The person's age is " + age +" and can vote.");
        } else {
            System.out.println("The person's age is " + age +" and cannot vote.");
        }

        // Close the scanner
        input.close();
    }
}
