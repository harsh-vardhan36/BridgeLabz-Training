//Program to count the number of digits in an integer
import java.util.Scanner;
public class DigitCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Declaring variable to store input number
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        //Declaring variable to store count of digits
        int count = 0;

        //Handling case when number is 0 (it has 1 digit)
        if (number == 0) {
            count = 1;
        } 
		else {
            while (number != 0) {
                //Removing last digit from number
                number = number / 10;
                count++;
            }
        }

        //Printing the count.
        System.out.println("The number of digits is: " + count);

        in.close();
    }
}
