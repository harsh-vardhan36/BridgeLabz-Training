//Program to check if the given number is a prime number or not
import java.util.Scanner;
public class PrimeCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Declaring variable to store input
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        //Declaring boolean variable to store prime status
        boolean isPrime = true;

        //Checking prime condition only for numbers greater than 1
        if (number <= 1) {
            isPrime = false;
        } 
		else {
            //Running loop from 2 to number-1
            for (int i = 2; i < number; i++) {
                //Checking if number is divisible by i
                if (number % i == 0) {
                    isPrime = false;
                    break; 
                }
            }
        }

        //Displaying result
        if (isPrime) {
            System.out.println(number + " is a Prime number.");
        } else {
            System.out.println(number + " is not a Prime number.");
        }

        in.close();
    }
}
