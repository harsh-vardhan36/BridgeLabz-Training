///Program to Check whether a number is negative, positive or zero.
import java.util.Scanner;
public class CheckNumber{
	public static void main(String [] args){
	
	Scanner in = new Scanner(System.in);
	
	//Creating object of CheckNumber
	CheckNumber CN = new CheckNumber();
	
	//Taking the variable from user.
	System.out.print("Enter the number: ");
	int number = in.nextInt();
	
	//Calling the method in object.
	System.out.println(CN.CheckNumber(number));
	}
	
	//Declaring a Method. 
	
	public int CheckNum(int number){
		if(number>0) return 1;
		else if (number ==0) return 0;
		else return -1;
	  
	}
}