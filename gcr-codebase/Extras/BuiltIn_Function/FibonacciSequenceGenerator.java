// Program: Fibonacci Sequence Generator

import java.util.Scanner;
public class FibonacciSequenceGenerator {

    // Function to generate and print Fibonacci sequence
    public static void generateFibonacci(int terms) {
        int first = 0, second = 1;

        System.out.print("Fibonacci Sequence up to " + terms + " terms: ");

        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println(); 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input from user
        System.out.print("Enter the number of terms: ");
        int terms = in.nextInt();

        // Call function
        generateFibonacci(terms);

        in.close();
    }
}
