///Program to check if 3 points are collinear using slope and area methods.
import java.util.Scanner;

public class CollinearityChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Taking input for 3 points
        System.out.print("Enter x1 and y1: ");
        int x1 = in.nextInt();
        int y1 = in.nextInt();

        System.out.print("Enter x2 and y2: ");
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        System.out.print("Enter x3 and y3: ");
        int x3 = in.nextInt();
        int y3 = in.nextInt();

        // Check using slope method
        boolean slopeCheck = areCollinearBySlope(x1, y1, x2, y2, x3, y3);

        // Check using area method
        boolean areaCheck = areCollinearByArea(x1, y1, x2, y2, x3, y3);

        // Display results
        System.out.println("\nUsing Slope Method: " + (slopeCheck ? "Collinear" : "Not Collinear"));
        System.out.println("Using Area Method: " + (areaCheck ? "Collinear" : "Not Collinear"));
    }

    // Method to check collinearity using slope
    public static boolean areCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        double slopeAB = (double)(y2 - y1) / (x2 - x1);
        double slopeBC = (double)(y3 - y2) / (x3 - x2);
        double slopeAC = (double)(y3 - y1) / (x3 - x1);

        return (slopeAB == slopeBC) && (slopeBC == slopeAC);
    }

    // Method to check collinearity using area of triangle
    public static boolean areCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * Math.abs(
            x1 * (y2 - y3) +
            x2 * (y3 - y1) +
            x3 * (y1 - y2)
        );
        return area == 0.0;
    }
}
