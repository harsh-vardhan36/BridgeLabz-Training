//Program to find multiplication tables of numbers from 6 to 9
import java.util.Scanner;
public class MultiplicationTableRange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking user input for the number
        System.out.print("Enter a number between 6 and 9: ");
        int number = in.nextInt();

        //Checking if number is in range
        if (number < 6 || number > 9) {
            System.out.println("Invalid input! Please enter a number between 6 and 9.");
        } 
		else {
            //Defining array to store multiplication results
            int[] multiplicationResult = new int[10];

            //Using for loop to calculate multiplication table
            for (int i = 1; i <= 10; i++) {
                multiplicationResult[i - 1] = number * i;
            }

            //Displaying multiplication table
            System.out.println("Multiplication table of " + number + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " * " + i + " = " + multiplicationResult[i - 1]);
            }
        }

        in.close();
    }
}
