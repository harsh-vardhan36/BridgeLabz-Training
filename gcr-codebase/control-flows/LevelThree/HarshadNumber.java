//Program to check if a number is a Harshad Number
import java.util.Scanner;
public class HarshadNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking number as input
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        //Declaring variable to store sum of digits
        int sum = 0;

        //Declaring variable to store original number
        int originalNumber = number;

        //Running while loop to access each digit
        while (originalNumber != 0) {
            //Finding last digit
            int digit = originalNumber % 10;

            //Adding digit to sum
            sum = sum + digit;

            //Removing last digit
            originalNumber = originalNumber / 10;
        }

        //Checking divisibility by sum of digits
        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number.");
        }
		else {
            System.out.println(number + " is Not a Harshad Number.");
        }

        in.close();
    }
}
