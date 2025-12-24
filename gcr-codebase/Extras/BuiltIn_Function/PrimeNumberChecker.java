// Program: Prime Number Checker with a separate function for prime check.
import java.util.Scanner;
public class PrimeNumberChecker {

    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false; 
        }
        if (num == 2) {
            return true; 
        }
        if (num % 2 == 0) {
            return false; 
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false; // divisible → not prime
            }
        }
        return true; // no divisors found → prime
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a number to check if it's prime: ");
        int number = in.nextInt();

        // Call prime-check method
        if (isPrime(number)) {
            System.out.println(number + " is a PRIME number.");
        } else {
            System.out.println(number + " is NOT a prime number.");
        }

        in.close();
    }
}
