//Utility class to perform Unit Conversions.
import java.util.*;

public class UnitConvertor{
    
    //Method to convert kilometers to miles
    public static double convertKmToMiles(double km){
        double km2miles = 0.621371;
        return km * km2miles;
    }
    
    //Method to convert miles to kilometers
    public static double convertMilesToKm(double miles){
        double miles2km = 1.60934;
        return miles * miles2km;
    }
    
    //Method to convert meters to feet
    public static double convertMetersToFeet(double meters){
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }
    
    //Method to convert feet to meters
    public static double convertFeetToMeters(double feet){
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
    
    //Main method to test conversions
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter kilometers to convert to miles: ");
        double km = in.nextDouble();
        System.out.println(km + " km = " + convertKmToMiles(km) + " miles");
        
        System.out.print("Enter miles to convert to kilometers: ");
        double miles = in.nextDouble();
        System.out.println(miles + " miles = " + convertMilesToKm(miles) + " km");
        
        System.out.print("Enter meters to convert to feet: ");
        double meters = in.nextDouble();
        System.out.println(meters + " meters = " + convertMetersToFeet(meters) + " feet");
        
        System.out.print("Enter feet to convert to meters: ");
        double feet = in.nextDouble();
        System.out.println(feet + " feet = " + convertFeetToMeters(feet) + " meters");
    }
}
