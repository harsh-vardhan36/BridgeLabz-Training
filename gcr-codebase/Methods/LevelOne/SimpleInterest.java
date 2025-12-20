///Program to calculate Simple Interset.
import java.util.Scanner;
public class SimpleInterest{
	public static void main(String [] args){
	
	Scanner in = new Scanner(System.in);
	
	//Creating object of Simple Interset
	SimpleInterest SI = new SimpleInterest();
	
	//Taking the variable from user.
	System.out.print("Enter the principal Amount: ");
	double principal = in.nextDouble();
	System.out.print("Enter the Rate Amount: ");
	double rate = in.nextDouble();
	System.out.print("Enter the Time Duration: ");
	double time = in.nextInt();
	
	SI.SimpleInterestCalculator(principal,rate,time);
	}
	
	void SimpleInterestCalculator(double principal,double rate, double time){
	 double simpleInterest = ((principal*rate*time)/100);
	 System.out.println("The Simple Interset is " + simpleInterest +" for Principal "+principal+", Rate of Interset "+ rate+" and Time "+time); 
	}
}