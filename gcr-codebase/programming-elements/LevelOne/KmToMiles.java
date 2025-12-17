import java.util.Scanner;

public class KmToMiles {
    public static void main(String[] args) {
        // Step 1: Create Scanner object to take input
        Scanner input = new Scanner(System.in);

        // Step 2: Declare variable km as double
        double km;

        // Step 3: Take user input for km
        System.out.print("Enter distance in kilometers: ");
        km = input.nextDouble();

        // Step 4: Convert km to miles using formula (1 mile = 1.6 km)
        double miles = km / 1.6;

        // Step 5: Print the output
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
    }
}
