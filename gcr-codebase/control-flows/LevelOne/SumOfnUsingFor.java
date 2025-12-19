
//program to find the sum of N natural number using formula and For loop.
import java.util.Scanner;

public class SumOfnUsingFor {
    public static void main(String[] args) {
        
        // Create a Scanner object to read input
        Scanner input = new Scanner(System.in);

        // Taking Number from user.
		System.out.print("Enter the Number: ");
        int number = input.nextInt();
		
		//check whether the number is natural or not.
		int SumUsingFormula =0;
		int SumUsingFor=0;
		if(number >=1) {
            SumUsingFormula = (number*(number +1)/2);
		   for(int i = number; i >0; i--){
		    SumUsingFor += i;
		   }

        }

        // Display the Both sum
        System.out.print((SumUsingFor==0 && SumUsingFormula == 0) ? "The Number is negative" : "The Sum using Formula is : " + SumUsingFormula +"\nThe Sum using For loop is : " + SumUsingFor);
    
		// Close the scanner
        input.close();
    }
}
