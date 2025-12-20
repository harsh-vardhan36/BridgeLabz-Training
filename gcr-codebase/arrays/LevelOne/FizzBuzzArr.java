//Program FizzBuzz: Save results in a String array and display with positions
import java.util.Scanner;
public class FizzBuzzArr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking user input
        System.out.print("Enter a positive integer: ");
        int number = in.nextInt();

        //Checking if input is valid
        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer.");
            in.close();
            return; 
        }

        //Creating String array to save results
        String[] results = new String[number + 1];

        //Looping from 0 to number
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0 && i != 0) {
                results[i] = "FizzBuzz";
            } 
			else if (i % 3 == 0 && i != 0) {
                results[i] = "Fizz";
            } 
			else if (i % 5 == 0 && i != 0) {
                results[i] = "Buzz";
            }
			else {
                results[i] = String.valueOf(i);
            }
        }

        //Displaying results with positions
        for (int i = 0; i <= number; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }

        in.close();
    }
}
