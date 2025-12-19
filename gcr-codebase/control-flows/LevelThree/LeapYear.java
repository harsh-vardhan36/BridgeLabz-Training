//Leap Year program to check whether a year is leap year or not.
import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        // Taking year as Input.
        System.out.print("Enter your year: ");
        int year=input.nextInt();
        
		// Given.
        if (year<1582){
            System.out.println("Invalid year : due to 1582 factor");
        }
		else{
            // check for leap year
            if(year%400==0){
                System.out.println("The year "+ year+" is a leap year");
            }
			else if (year%100==0) {
                System.out.println("The year "+ year+" is a not leap year");
            }
			else if (year % 4 == 0) {
                System.out.println("The year "+ year+" is a leap year");
            }
			else{
                System.out.println("The year "+ year+" is not a leap year");
            }
        }
        input.close();
    }
}