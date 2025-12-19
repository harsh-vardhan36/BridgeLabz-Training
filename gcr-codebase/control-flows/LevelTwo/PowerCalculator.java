//Program to find the power of a number
import java.util.Scanner;
public class PowerCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Declaring variables to store input
        System.out.print("Enter the number: ");
        int number = in.nextInt();

        System.out.print("Enter the power: ");
        int power = in.nextInt();

        //Checking if inputs are positive integers
        if (number > 0 && power >= 0) { 1
            int result = 1;

            //Running loop from 1 to power
            for (int i = 1; i <= power; i++) {
                //Multiplying result by number in each iteration
                result = result * number;
            }

            //Displaying the final result
            System.out.println(number + " raised to the power " + power + " is: " + result);
        } 
		 else {
            System.out.println("Please enter positive integers for number and non-negative integer for power.");
         }

        in.close();
    }
}
