///Program to find the sum of n natural numbers using loop
import java.util.Scanner;
public class SumOfN{
	public static void main(String [] args){
	
	Scanner in = new Scanner(System.in);
	
	//Creating object of SumOfN
	SumOfN SN = new SumOfN();
	
	//Taking the variable from user.
	System.out.print("Enter the number: ");
	int number = in.nextInt();
	
	//Calling the method in object.
	System.out.println(SN.SumOfn(number));
	}
	
	//Declaring a Method. 
	
	public static int SumOfn(int number){
		int sum = 0;
		while(number>0){
		 sum +=number;
		 number--;
		}
		return sum;
	}
}