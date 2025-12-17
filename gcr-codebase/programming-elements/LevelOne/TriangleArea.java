import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        // Step 1: Create Scanner object to take input
        Scanner input = new Scanner(System.in);

        // Step 2: Take user input for base and height in cm
        System.out.print("Enter the base of the triangle in cm: ");
        double base = input.nextDouble();

        System.out.print("Enter the height of the triangle in cm: ");
        double height = input.nextDouble();

        // Step 3: Calculate area in square centimeters
        double areaCm2 = 0.5 * base * height;

        // Step 4: Convert area to square inches
        double areaIn2 = areaCm2 / (2.54 * 2.54);

        // Step 5: Print results
        System.out.println("The area of the triangle is " + areaCm2 + " square centimeters "
                           + " and " + areaIn2 + " square inches.");
    }
}
