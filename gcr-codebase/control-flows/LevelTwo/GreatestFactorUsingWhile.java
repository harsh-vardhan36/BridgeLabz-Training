//Program to find the greatest Factor from a number
import java.util.Scanner;
public class GreatestFactorUsingWhile {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Declaring the variable to store input
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        //Declaring the variable to store greatest factor
        int greatestFactor = 1;

        //Declaring counter variable and assigning number-1
        int counter = number - 1;

        //Running while loop till counter is greater than or equal to 1
        while (counter >= 1) {
            //Checking if number is divisible by counter
            if (number % counter == 0) {
                greatestFactor = counter;
                break; //Breaking loop.
            }
            counter--; //Decreasing counter
        }
		
        //Displaying the greatest factor
        System.out.println("The greatest factor of " + number + " is " + greatestFactor);

        //Closing Scanner object
        in.close();
    }
}
