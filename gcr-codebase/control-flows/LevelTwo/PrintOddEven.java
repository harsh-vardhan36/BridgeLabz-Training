import java.util.Scanner;
 
 //Creating a program to check Odd or Even till Given number from 1.
 public class PrintOddEven {
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	
	//Taking the number From User.
	  System.out.print("Enter the number: ");
	  int number = input.nextInt();
	  
	//Created a String Variable to store odd and even.
	  String check;
	 
	//Using a for loop: to iterate till number.
	  for(int i = 1; i <=number; i++) {
	//Checking whether the number is odd or even and assigning it in check variable.
	    if (i%2==0) check = "Even";
		else check = "Odd";
	
	//Displaying the Answer.
	   System.out.println("The number : "+i+" is "+check);
	  }
	}
 }