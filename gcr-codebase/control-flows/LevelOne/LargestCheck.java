// Check the largest. It prints whether the first, second,
// or third number holds the largest value.

import java.util.Scanner;

public class LargestCheck {
    public static void main(String[] args) {
        
        // Create a Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Taking Input from the user 
        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();

        System.out.print("Enter the third number: ");
        int number3 = input.nextInt();

        // Check if the first number is greater than both the second and third
        if (number1 > number2 && number1 > number3) {
            System.out.println("Is the first number the largest? Yes");
        } else {
            System.out.println("Is the first number the largest? No");
        }

        // Check if the second number is greater than both the first and third
        if (number2 > number1 && number2 > number3) {
            System.out.println("Is the second number the largest? Yes");
        } else {
            System.out.println("Is the second number the largest? No");
        }

        // Check if the third number is greater than both the first and second
        if (number3 > number1 && number3 > number2) {
            System.out.println("Is the third number the largest? Yes");
        } else {
            System.out.println("Is the third number the largest? No");
        }

        // Close the scanner to free resources
        input.close();
    }
}
