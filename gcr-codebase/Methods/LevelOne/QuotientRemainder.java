///Program to find the Quotient and Remainder of 2 numbers.
import java.util.Scanner;
public class QuotientRemainder{
    public static void main(String [] args){
    
        Scanner in = new Scanner(System.in);
        
        //Creating object of QuotientRemainder
        QuotientRemainder QR = new QuotientRemainder();
        
        //Taking the numbers from user.
        System.out.print("Enter the number: ");
        int number = in.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = in.nextInt();
        
        int[] result = QR.findRemainderAndQuotient(number, divisor);
        
        System.out.println("The Quotient is " + result[1] + 
                           " and the Remainder is " + result[0] +
                           " for Number " + number + " divided by Divisor " + divisor);
    }
    
    public static int[] findRemainderAndQuotient(int number, int divisor){
        int remainder = number % divisor;
        int quotient = number / divisor;
        
        return new int[]{remainder, quotient};
    }
}
