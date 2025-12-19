//Program to check if a number is an Abundant Number
import java.util.Scanner;
public class AbundantNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking number as input
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        //Declaring variable to store sum of divisors
        int sum = 0;

        //Running loop to find divisors from 1 to number/2
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                //Adding divisor to sum
                sum = sum + i;
            }
        }

        //Checking if sum of divisors is greater than number
        if (sum > number) {
            System.out.println(number + " is an Abundant Number.");
        } 
		else {
            System.out.println(number + " is Not an Abundant Number.");
        }

        in.close();
    }
}
