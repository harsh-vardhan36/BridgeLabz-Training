import java.util.Scanner;

public class YardMilesConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: distance in feet
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = sc.nextDouble();

        // Conversion
        double distanceInYards = distanceInFeet / 3.0;
        double distanceInMiles = distanceInFeet / 5280.0;

        // Height conversion (feet → cm, feet + inches)
        double heightInCm = distanceInFeet * 30.48; // 1 foot = 30.48 cm
        int feetPart = (int) distanceInFeet;
        double inchesPart = (distanceInFeet - feetPart) * 12; // 1 foot = 12 inches

        // Output
        System.out.println("Distance in yards: " + distanceInYards);
        System.out.println("Distance in miles: " + distanceInMiles);
        System.out.println("Your Height in cm is " + heightInCm + " while in feet is " + feetPart +" and inches is " + inchesPart);
    }
}
