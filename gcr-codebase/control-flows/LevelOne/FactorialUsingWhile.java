import java.util.*;
public class FactorialUsingWhile{
	public static void main(String [] args){
		Scanner input=new Scanner(System.in);
		
		//Taking input from the user
        System.out.print("Enter your number: ");
		int number=input.nextInt();
		// Initializing the factorial variable as fact=1;
		int fact=1;
		// calculating the factorial using while loop
		while(number>0){
			fact*=number;
			number--;
		}
		System.out.println("The factorial is : "+ fact);
			
		input.close();
		
	}
}