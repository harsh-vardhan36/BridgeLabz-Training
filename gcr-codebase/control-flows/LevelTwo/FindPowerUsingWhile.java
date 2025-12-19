//Program to find the power of a number using while loop
import java.util.Scanner;
public class FindPowerUsingWhile {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Declaring variables to store input
        System.out.print("Enter the number: ");
        int number = in.nextInt();

        System.out.print("Enter the power: ");
        int power = in.nextInt();

        //Declaring result variable with initial value 1
        int result = 1;

        //Declaring counter variable and initializing to 0
        int counter = 0;

        //Running while loop till counter equals power
        while (counter < power) {
            //Multiplying result by number in each iteration
            result = result * number;

            //Incrementing counter
            counter++;
        }

        //Displaying the final result
        System.out.println(number + " raised to the power " + power + " is: " + result);
		
        in.close();
    }
}
