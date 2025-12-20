//Program to find the frequency of each digit in a number
import java.util.Scanner;
public class DigitFrequency {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking user input
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        //Step 1: Find count of digits
        int temp = number;
        int count = 0;
        while (temp != 0) {
            temp = temp / 10;
            count++;
        }

        //Step 2: Store digits in an array
        int[] digits = new int[count];
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10; //Extract last digit
            temp = temp / 10;      //Reduce number
        }

        //Step 3: Define frequency array of size 10 (digits 0–9)
        int[] frequency = new int[10];

        //Step 4: Loop through digits array and increase frequency
        for (int i = 0; i < count; i++) {
            frequency[digits[i]]++;
        }

        //Step 5: Display frequency of each digit
        System.out.println("\n--- Digit Frequency ---");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s).");
            }
        }

        in.close();
    }
}
