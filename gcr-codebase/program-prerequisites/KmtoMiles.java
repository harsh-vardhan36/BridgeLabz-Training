import java.util.Scanner;
 public class KmtoMiles{
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Enter distance in Kilometer (Km)");
	double Kilometer = in.nextDouble();
	//Formula: Miles = kilometer * 0.621371
	double Miles = Kilometer*0.621371;
	System.out.println("Miles: "+Miles);
	}
 }