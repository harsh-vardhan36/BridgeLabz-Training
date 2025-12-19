
// Check Whether the First is smallest among three given numbers.

import java.util.Scanner;

public class SmallestCheck {
    public static void main(String[] args) {
        
        // Create a Scanner object to read input from the user
        Scanner input = new Scanner(System.in);

        // Taking Input f0r three numbers
        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();

        System.out.print("Enter the third number: ");
        int number3 = input.nextInt();

        // Check if the first number is smaller than both the second and third
        if (number1 < number2 && number1 < number3) {
            System.out.println("Is the first number the smallest? Yes");
        } else {
            System.out.println("Is the first number the smallest? No");
        }

        // Close the Scanner.
        input.close();
    }
}
