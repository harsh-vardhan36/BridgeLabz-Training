//Find the factors of a number using the For loop.
import java.util.Scanner;
public class FactorUsingFor {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);

        //Take input from user
        System.out.print("Enter your number : ");
        int number=in.nextInt();

        //check whether the number is positive
        if(number<=0){
            System.out.println("The number entered is not positive");
        }
		else{
            // Running a For loop from 1 to number and print if number%i=0.
                for(int i = 1; i < number; i++){
					if(number%i ==0){
                    System.out.println(i);
                    }
				}
        }
        in.close();
    }
}