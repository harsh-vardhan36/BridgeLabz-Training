import java.util.Scanner;

public class SquareSide {
    public static void main(String[] args) {
        // Step 1: Create Scanner object to take input
        Scanner input = new Scanner(System.in);

        // Step 2: Take user input for perimeter
        System.out.print("Enter the perimeter of the square: ");
        double perimeter = input.nextDouble();

        // Step 3: Calculate side length
        double side = perimeter / 4;

        // Step 4: Print results
        System.out.println("The length of the side is " + side +
                           " whose perimeter is " + perimeter);
    }
}
