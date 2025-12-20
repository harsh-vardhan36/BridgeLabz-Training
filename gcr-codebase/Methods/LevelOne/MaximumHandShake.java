///Program to Find Maximum number of HandShake.
import java.util.Scanner;
public class MaximumHandShake{
	public static void main(String [] args){
	
	Scanner in = new Scanner(System.in);
	
	//Creating object of MaximumHandShake
	MaximumHandShake HS = new MaximumHandShake();
	
	//Taking the variable from user.
	System.out.print("Enter the number of Student: ");
	int numberOfStudents = in.nextInt();
	
	//Calling the method in object.
	HS.possibleHandshake(numberOfStudents);
	}
	
	//Declaring a Method.
	void possibleHandshake(int numberOfStudents){
	 int numberOfHandShake = ((numberOfStudents*(numberOfStudents-1))/2);
	 System.out.println("The Number of Possible HandShake is " + numberOfHandShake); 
	}
}