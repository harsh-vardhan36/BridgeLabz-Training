//Program to find all the multiples of a number below 100 using while loop
import java.util.Scanner;
public class FindMultiplesUsingWhile {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Declaring the variable to store input
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        //Checking if number is positive and less than 100
        if (number > 0 && number < 100) {
            //Declaring counter variable and assigning 100
            int counter = 100;

            //Running while loop till counter is greater than or equal to 1
            while (counter >= 1) {
                //Checking if counter is a multiple of number
                if (counter % number == 0) {
                    System.out.println(counter);
                }
                //Decreasing counter
                counter--;
            }
        } 
		else {
            System.out.println("Please enter a positive integer less than 100.");
        }
        in.close();
    }
}
