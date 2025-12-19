//program to Calculate Factorial using For loop
import java.util.*;
public class FactorialUsingFor{
	public static void main(String [] args){
		Scanner input=new Scanner(System.in);
		
		//Taking input from the user
        System.out.print("Enter your number");
		int number=input.nextInt();
		// Initializing the factorial as fact=1;
		int fact=1;
		// calculating the factorial using For loop
		for(int i=number;i>0;i--){
			fact*=i;
		}
		System.out.println("The factorial is : "+ fact);
			
		
		
	}
}