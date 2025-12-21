///Program to calculate Wind Chill Temperature.
import java.util.Scanner;
public class WindChill{
    public static void main(String [] args){
    
        Scanner in = new Scanner(System.in);
        
        //Creating object of WindChill
        WindChill WC = new WindChill();
        
        //Taking the values from user.
        System.out.print("Enter the temperature in Fahrenheit: ");
        double temperature = in.nextDouble();
        System.out.print("Enter the wind speed in miles per hour: ");
        double windSpeed = in.nextDouble();
        
        double windChill = WC.calculateWindChill(temperature, windSpeed);
        
        System.out.println("The Wind Chill Temperature is " + windChill +
                           " for Temperature " + temperature +
                           "°F and Wind Speed " + windSpeed + " mph.");
    }
    
    public double calculateWindChill(double temperature, double windSpeed){
        double windChill = 35.74 + (0.6215 * temperature) 
                         + ((0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16));
        return windChill;
    }
}
