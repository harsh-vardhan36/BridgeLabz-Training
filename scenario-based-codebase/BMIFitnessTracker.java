// Maya’s BMI Fitness Tracker
import java.util.Scanner; 
public class BMIFitnessTracker {

    // Calculates BMI using weight and height
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    // Displays BMI category using if-else
    public static void displayBMICategory(double bmi) {
        if (bmi < 18.5) {
            System.out.println("Category: Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("Category: Normal");
        } else {
            System.out.println("Category: Overweight");
        }
    }

    // Program execution starts here
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weight in kilograms: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height in meters: ");
        double height = scanner.nextDouble();

        double bmi = calculateBMI(weight, height); // BMI calculation

        System.out.println("Your BMI is: " + bmi);
        displayBMICategory(bmi); // Display BMI category

        scanner.close();
    }
}