///Program to find the sum of n natural numbers using recursion and compare with formula.
import java.util.Scanner;
public class SumOfNaturalNumbers{
    public static void main(String [] args){
    
        Scanner in = new Scanner(System.in);
        
        //Creating object of SumOfNaturalNumbers
        SumOfNaturalNumbers SN = new SumOfNaturalNumbers();
        
        //Taking the number from user.
        System.out.print("Enter a natural number: ");
        int n = in.nextInt();
        
        //Checking if the number is natural
        if(n <= 0){
            System.out.println("Please enter a valid natural number (greater than 0).");
            return;
        }
        
        //Recursive sum
        int recursiveSum = SN.findSumRecursive(n);
        
        //Formula sum
        int formulaSum = SN.findSumFormula(n);
        
        //Displaying results
        System.out.println("Sum of first " + n + " natural numbers using recursion: " + recursiveSum);
        System.out.println("Sum of first " + n + " natural numbers using formula: " + formulaSum);
        
        //Comparison
        if(recursiveSum == formulaSum){
            System.out.println("Both computations are correct and results match!");
        } else {
            System.out.println("Results do not match. Please check the logic.");
        }
    }
    
    //Recursive method to find sum of n natural numbers
    public int findSumRecursive(int n){
        if(n == 1){
            return 1;
        }
        return n + findSumRecursive(n - 1);
    }
    
    //Formula method to find sum of n natural numbers
    public int findSumFormula(int n){
        return (n * (n + 1)) / 2;
    }
}
