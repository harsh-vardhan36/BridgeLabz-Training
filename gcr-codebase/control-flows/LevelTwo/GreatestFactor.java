//Program to find the greatest Factor from a number
import java.util.Scanner;
public class GreatestFactor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Declaring the variable to store input
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        //Declaring the variable to store greatest factor
        int greatestFactor = 1;

        for (int i = number - 1; i >= 1; i--) {
            //Checking if number is divisible by i
            if (number % i == 0) {
                greatestFactor = i;
                break; //Breaking loop
            }
        }

        //Displaying the greatest factor
        System.out.println("The greatest factor of " + number + " is " + greatestFactor);

        //Closing Scanner object
        in.close();
    }
}
