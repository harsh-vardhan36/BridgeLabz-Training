///Program to calculate Euclidean distance and equation of a line between two points.
import java.util.Scanner;

public class LineCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Taking input for two points
        System.out.print("Enter x1 and y1: ");
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();

        System.out.print("Enter x2 and y2: ");
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();

        // Calculate Euclidean distance
        double distance = calculateDistance(x1, y1, x2, y2);

        // Calculate slope and y-intercept
        double[] lineEquation = calculateLineEquation(x1, y1, x2, y2);
        double slope = lineEquation[0];
        double intercept = lineEquation[1];

        // Display results
        System.out.printf("\nEuclidean Distance: %.2f\n", distance);
        System.out.printf("Equation of Line: y = %.2fx + %.2f\n", slope, intercept);
    }

    // Method to calculate Euclidean distance
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to calculate slope and y-intercept
    public static double[] calculateLineEquation(double x1, double y1, double x2, double y2) {
        double slope = (y2 - y1) / (x2 - x1);
        double intercept = y1 - slope * x1;
        return new double[]{slope, intercept};
    }
}
