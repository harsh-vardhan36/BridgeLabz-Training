//program to print odd and even numbers between 1 to the number
// entered by the user.
import java.util.Scanner;
public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get input from user
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        // Check if input is a natural number
        if (number <= 0) {
            System.out.println("Please enter a natural number greater than 0.");
        } else {
            // Iterate from 1 to number
            for (int i = 1; i <= number; i++) {
                // Step 4: Check odd/even
                if (i % 2 == 0) {
                    System.out.println(i + " is an Even number");
                } else {
                    System.out.println(i + " is an Odd number");
                }
            }
        }

        input.close();
    }
}
