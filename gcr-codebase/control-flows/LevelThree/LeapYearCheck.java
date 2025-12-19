//Program to determine Leap Year using single if condition
import java.util.Scanner;
public class LeapYearCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Declaring variable to store input year
        System.out.print("Enter a year: ");
        int year = in.nextInt();

        //Checking leap year using single if condition.
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            System.out.println(year + " is a Leap Year.");
        } 
		else {
            System.out.println(year + " is not a Leap Year.");
        }

        in.close();
    }
}
