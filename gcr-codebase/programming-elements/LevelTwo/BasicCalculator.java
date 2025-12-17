import java.util.Scanner;
public class BasicCalculator{
  public static void main(String[] args){
	//Creating two variable to take two number from user as input
	double number1, number2;
	
	//Using Scanner Class to take input..
  Scanner input = new Scanner(System.in);
	//taking number1 as input
	System.out.println("Enter Number 1: ");
	number1 = input.nextDouble();
	//taking number2 as input
   	System.out.println("Enter Number 2: ");
	number2 = input.nextDouble();
	input.close();
	//performing Addition
		double addition = number1 + number2;
	//performing Subtraction
		double subtraction = number1 - number2;
	//performing Multiplication
		double multiplication = number1*number2;
	//performing Division
		double division = number1/number2;
	
  System.out.println("The addition, Subtraction, multiplication and division value of 2 numbers "+number1+" and " +number2 +" is "+addition+", "+subtraction+", "+multiplication+", "+division+".");

	}
}