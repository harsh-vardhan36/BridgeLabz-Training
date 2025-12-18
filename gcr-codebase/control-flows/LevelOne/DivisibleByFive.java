import java.util.Scanner;
//Creating a class to check whether a number is divisible by 5 or not.
 public class DivisibleByFive{
	public static void main(String [] args){
	    Scanner input = new Scanner(System.in);
	
	 //Take input for a number.
	 System.out.print("Enter a Number: ");
	 int number = input.nextInt();
	 
	//Display if the number is divisible by 5.
	System.out.println("Is the number divisible by 5 " + (number%5==0));
	}
 }