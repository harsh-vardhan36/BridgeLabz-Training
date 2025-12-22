///Program to check whether a given year is a Leap Year or not.
import java.util.Scanner;
public class LeapYear{
    public static void main(String [] args){
    
        Scanner in = new Scanner(System.in);
        
        //Creating object of LeapYear
        LeapYear LY = new LeapYear();
        
        //Taking the year from user.
        System.out.print("Enter the year: ");
        int year = in.nextInt();
        
        //Checking Gregorian calendar condition
        if(year < 1582){
            System.out.println("The Leap Year program only works for year >= 1582 (Gregorian calendar).");
        } else {
            boolean isLeap = LY.checkLeapYear(year);
            
            if(isLeap){
                System.out.println("The Year " + year + " is a Leap Year.");
            } else {
                System.out.println("The Year " + year + " is NOT a Leap Year.");
            }
        }
    }
    
    //Method to check for Leap Year
    public boolean checkLeapYear(int year){
        //Condition: divisible by 4 and not divisible by 100 OR divisible by 400
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            return true;
        } else {
            return false;
        }
    }
}
