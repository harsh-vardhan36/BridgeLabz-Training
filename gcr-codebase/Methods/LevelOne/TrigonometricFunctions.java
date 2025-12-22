//Program to calculate various Trigonometric Functions.
import java.util.Scanner;
public class TrigonometricFunctions{
    public static void main(String [] args){
    
        Scanner in = new Scanner(System.in);
        
        //Creating object of TrigonometricFunctions
        TrigonometricFunctions TF = new TrigonometricFunctions();
        
        //Taking the angle from user.
        System.out.print("Enter the angle in degrees: ");
        double angle = in.nextDouble();
        
        double[] result = TF.calculateTrigonometricFunctions(angle);
        
        System.out.println("For angle " + angle + " degrees:");
        System.out.println("Sine value is " + result[0]);
        System.out.println("Cosine value is " + result[1]);
        System.out.println("Tangent value is " + result[2]);
    }
    
    public double[] calculateTrigonometricFunctions(double angle){
        //Convert degrees to radians
        double radians = Math.toRadians(angle);
        
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        
        return new double[]{sine, cosine, tangent};
    }
}
