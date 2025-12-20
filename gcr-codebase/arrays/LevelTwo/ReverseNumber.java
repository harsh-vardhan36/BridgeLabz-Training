//Program to reverse a number using arrays

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking user input
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        //Finding count of digits
        int temp = number;
        int count = 0;
        while (temp != 0) {
            temp = temp / 10;
            count++;
        }

        //Defining array to store digits
        int[] digits = new int[count];

        //Extracting digits and storing in array
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10; //last digit
            temp = temp / 10;      //reduce number
        }

        //Creating reverse array
        int[] reverseDigits = new int[count];
        for (int i = 0; i < count; i++) {
            reverseDigits[i] = digits[count - 1 - i];
        }

        //Displaying reversed number using array
        System.out.print("Reversed number: ");
        for (int i = 0; i < reverseDigits.length; i++) {
            System.out.print(reverseDigits[i]);
        }
        System.out.println();

        in.close();
    }
}
