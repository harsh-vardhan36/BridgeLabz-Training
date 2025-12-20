//Program to save odd and even numbers into separate arrays
import java.util.Scanner;
public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking user input
        System.out.print("Enter a natural number: ");
        int number = in.nextInt();

        //Checking if input is a natural number
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number greater than 0.");
            in.close();
            return; //Exiting program
        }

        //Defining arrays for odd and even numbers
        int[] odd = new int[number / 2 + 1];
        int[] even = new int[number / 2 + 1];

        //Declaring index variables
        int oddIndex = 0;
        int evenIndex = 0;

        //Iterating from 1 to number
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                //Saving even number
                even[evenIndex] = i;
                evenIndex++;
            }
			else {
                //Saving odd number
                odd[oddIndex] = i;
                oddIndex++;
            }
        }

        //Printing odd numbers array
        System.out.println("Odd numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }
        System.out.println();

        //Printing even numbers array
        System.out.println("Even numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }
        System.out.println();

        in.close();
    }
}
