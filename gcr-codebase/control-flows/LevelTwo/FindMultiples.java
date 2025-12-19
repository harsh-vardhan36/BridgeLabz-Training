//Program to find all the multiples of a number below 100
import java.util.Scanner;
public class FindMultiples {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Declaring the variable to store input
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        //Checking if number is positive and less than 100
        if (number > 0 && number < 100) {
            //Running loop backward from 100 to 1
            for (int i = 100; i >= 1; i--) {
                //Checking if i is a multiple of number
                if (i % number == 0) {
                    System.out.println(i);
                }
            }
        } 
		else {
            System.out.println("Please enter a positive integer less than 100.");
        }

        //Closing Scanner object
        in.close();
    }
}
