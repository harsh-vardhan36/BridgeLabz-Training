import java.util.*;
 public class PowerCalculation{
	public static void main(String [] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the base number: ");
	double base = in.nextDouble();
	System.out.println("Enter the Exponent: ");
	double Exponent = in.nextDouble();
	double Result = Math.pow(base, Exponent);
	System.out.println("The result is: "+Result);
	in.close();
	
	
	}
 }