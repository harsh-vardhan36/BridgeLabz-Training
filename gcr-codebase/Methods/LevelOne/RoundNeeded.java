///Program to Find Numbers of rounds an atheletes needs to complete 5 km distance.
import java.util.Scanner;
public class RoundNeeded{
	public static void main(String [] args){
	
	Scanner in = new Scanner(System.in);
	
	//Creating object of RoundNeeded
	RoundNeeded RN = new RoundNeeded();
	
	//Taking the variable from user.
	double [] sides = new double[3];
	for(int i = 1; i <=3; i++){
	System.out.print("Enter the "+i+" Side of Triangle: ");
	sides[i-1] = in.nextDouble();
	
	
	//Calling the method in object.
	RN.roundsNeeded(sides);
	}
	}
	
	//Declaring a Method. 
	
	void roundsNeeded(int[] sides){
	 int FiveKm = 5000; //1 km = 1000 m.
	 double perimeter = sides[0] + sides[1]+sides[2];
	 System.out.println("Round Needed: " + FiveKm/perimeter); 
	}
}