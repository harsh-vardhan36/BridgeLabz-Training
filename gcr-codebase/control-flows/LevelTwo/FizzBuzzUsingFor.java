//Program to print Fizz, Buzz and FizzBuzz.
import java.util.*;
public class FizzBuzzUsingFor{
	public static void main(String [] args){
		Scanner input=new Scanner(System.in);
		
		//Taking Number From user.
        System.out.println("Enter the number:");
		int number=input.nextInt();
		
		//check for positive number 
		if(number<=0){
			System.out.println("The number entered is not positive");
		}else{
		     // using for loop to print numbers upto given input.
			for(int i=1;i<=number;i++){
				// check if the number is multiple of 3 and 5
				if(i%3==0 && i%5==0){
					System.out.println("FizzBuzz");
				}
				else if(i %3==0){
					System.out.println("Fizz");
				}
				else if(i %5==0){
					System.out.println("Buzz");
				}
				else{
					System.out.println(i);
				}
			}
		}
		input.close();
	}
}