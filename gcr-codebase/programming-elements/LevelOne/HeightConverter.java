import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        // Step 1: Create Scanner object to take input
        Scanner input = new Scanner(System.in);

        // Step 2: Take user input for height in cm
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();

        // Step 3: Convert cm to inches
        double totalInches = heightCm / 2.54;

        // Step 4: Convert inches to feet and remaining inches
        int feet = (int) (totalInches / 12);   // whole feet
        double inches = totalInches % 12;      // remainder inches

        // Step 5: Print results
        System.out.println("Your Height in cm is " + heightCm +
                           " while in feet is " + feet +
                           " and inches is " + inches);
    }
}
