//Program to check numbers as positive, negative, or zero
//Finally compare first and last elements of the array
import java.util.Scanner;
public class NumberCheckInArr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Defining integer array of 5 elements
        int[] numbers = new int[5];

        //Taking user input.
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = in.nextInt();
        }

        //Looping through the array
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            if (num > 0) {
                //Checking even or odd for positive numbers
                if (num % 2 == 0) {
                    System.out.println("Number " + num + " is Positive and Even.");
                } 
				else {
                    System.out.println("Number " + num + " is Positive and Odd.");
                }
            }
			else if (num < 0) {
                System.out.println("Number " + num + " is Negative.");
            } 
			else {
                System.out.println("Number " + num + " is Zero.");
            }
        }

        //Comparing first and last elements of the array
        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        if (first == last) {
            System.out.println("First element " + first + " is equal to last element " + last + ".");
        }
		else if (first > last) {
            System.out.println("First element " + first + " is greater than last element " + last + ".");
        }
		else {
            System.out.println("First element " + first + " is less than last element " + last + ".");
        }

        in.close();
    }
}
