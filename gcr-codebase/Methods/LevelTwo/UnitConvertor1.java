//Utility class to perform Unit Conversions.
import java.util.*;

public class UnitConvertor{
    
    //Method to convert yards to feet
    public static double convertYardsToFeet(double yards){
        double yards2feet = 3;
        return yards * yards2feet;
    }
    
    //Method to convert feet to yards
    public static double convertFeetToYards(double feet){
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }
    
    //Method to convert meters to inches
    public static double convertMetersToInches(double meters){
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }
    
    //Method to convert inches to meters
    public static double convertInchesToMeters(double inches){
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }
    
    //Method to convert inches to centimeters
    public static double convertInchesToCentimeters(double inches){
        double inches2cm = 2.54;
        return inches * inches2cm;
    }
    
    //Main method to test conversions
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter yards to convert to feet: ");
        double yards = in.nextDouble();
        System.out.println(yards + " yards = " + convertYardsToFeet(yards) + " feet");
        
        System.out.print("Enter feet to convert to yards: ");
        double feet = in.nextDouble();
        System.out.println(feet + " feet = " + convertFeetToYards(feet) + " yards");
        
        System.out.print("Enter meters to convert to inches: ");
        double meters = in.nextDouble();
        System.out.println(meters + " meters = " + convertMetersToInches(meters) + " inches");
        
        System.out.print("Enter inches to convert to meters: ");
        double inches = in.nextDouble();
        System.out.println(inches + " inches = " + convertInchesToMeters(inches) + " meters");
        
        System.out.print("Enter inches to convert to centimeters: ");
        double inches2 = in.nextDouble();
        System.out.println(inches2 + " inches = " + convertInchesToCentimeters(inches2) + " cm");
    }
}
