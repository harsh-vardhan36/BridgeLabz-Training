///Program to divide N chocolates among M children.
import java.util.Scanner;
public class ChocolateDistribution{
    public static void main(String [] args){
    
        Scanner in = new Scanner(System.in);
        
        //Creating object of ChocolateDistribution
        ChocolateDistribution CD = new ChocolateDistribution();
        
        //Taking the values from user.
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = in.nextInt();
        System.out.print("Enter the number of children: ");
        int numberOfChildren = in.nextInt();
        
        int[] result = CD.findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
        
        System.out.println("Each child will get " + result[1] + 
                           " chocolates and the remaining chocolates are " + result[0] +
                           " when " + numberOfChocolates + " chocolates are divided among " + numberOfChildren + " children.");
    }
    
    public static int[] findRemainderAndQuotient(int number, int divisor){
        int remainder = number % divisor;
        int quotient = number / divisor;
        
        return new int[]{remainder, quotient};
    }
}
