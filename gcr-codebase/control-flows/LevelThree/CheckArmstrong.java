//Program to check if a number is Armstrong or not
import java.util.Scanner;
public class CheckArmstrong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Declaring variable to store input number
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        //Declaring variable to store sum of cubes
        int sum = 0;

        //Declaring variable to store original number
        int originalNumber = number;

        while (originalNumber != 0) {
            //Finding last digit using modulus operation
            int digit = originalNumber % 10;
            sum = sum + (digit * digit * digit);

            //Removing last digit using division
            originalNumber = originalNumber / 10;
        }

        //Checking if sum equals the number
        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } 
		else {
            System.out.println(number + " is not an Armstrong number.");
        }

        in.close();
    }
}
