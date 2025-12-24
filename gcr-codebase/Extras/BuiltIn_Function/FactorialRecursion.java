// Program: Factorial Using Recursion

import java.util.Scanner;
public class FactorialRecursion {

    // Function to take input from user
    public static int getInput(Scanner in) {
        System.out.print("Enter a number: ");
        return in.nextInt();
    }

    // Recursive function...
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; 
        }
        return n * factorial(n - 1); 
    }

    // Function to display result
    public static void displayResult(int num, long result) {
        System.out.println("Factorial of " + num + " is: " + result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Step 1: Input
        int number = getInput(in);

        // Step 2: Calculation
        long result = factorial(number);

        // Step 3: Output
        displayResult(number, result);

        in.close();
    }
}
