//Program to store digits of a number in an array
//and find the largest and second largest digit
//with dynamic resizing of the array when full

import java.util.Scanner;

public class LargestDigitsDynamic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking user input
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        //Defining initial maxDigit and array to store digits
        int maxDigit = 10;
        int[] digits = new int[maxDigit];

        //Index variable to track array position
        int index = 0;

        //Extracting digits from number
        while (number != 0) {
            int digit = number % 10; //Removing last digit
            number = number / 10;    //Reducing number

            //Checking if array is full
            if (index == maxDigit) {
                //Increase maxDigit by 10
                maxDigit = maxDigit + 10;

                //Create new temp array with updated size
                int[] temp = new int[maxDigit];

                //Copy existing digits into temp array
                for (int j = 0; j < digits.length; j++) {
                    temp[j] = digits[j];
                }

                //Assign temp back to digits
                digits = temp;
            }

            //Storing digit in array
            digits[index] = digit;
            index++;
        }

        //Variables to store largest and second largest digit
        int largest = 0;
        int secondLargest = 0;

        //Looping through array to find largest and second largest
        for (int i = 0; i < index; i++) {
            int current = digits[i];

            if (current > largest) {
                secondLargest = largest; //Update second largest
                largest = current;       //Update largest
            } 
			else if (current > secondLargest && current != largest) {
                secondLargest = current; //Update second largest
            }
        }

        //Displaying results
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

        in.close();
    }
}
