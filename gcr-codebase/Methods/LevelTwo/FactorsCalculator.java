///Program to find factors of a number and calculate sum, product, and sum of squares of factors.
import java.util.Scanner;
public class FactorsCalculator{
    public static void main(String [] args){
    
        Scanner in = new Scanner(System.in);
        
        //Creating object of FactorsCalculator
        FactorsCalculator FC = new FactorsCalculator();
        
        //Taking the number from user.
        System.out.print("Enter the number: ");
        int number = in.nextInt();
        
        int[] factors = FC.findFactors(number);
        
        //Displaying the factors
        System.out.print("The factors of " + number + " are: ");
        for(int factor : factors){
            System.out.print(factor + " ");
        }
        System.out.println();
        
        //Calculations
        int sum = FC.findSum(factors);
        int product = FC.findProduct(factors);
        int sumOfSquares = FC.findSumOfSquares(factors);
        
        //Displaying results
        System.out.println("Sum of factors: " + sum);
        System.out.println("Product of factors: " + product);
        System.out.println("Sum of squares of factors: " + sumOfSquares);
    }
    
    //Method to find factors of a number
    public static int[] findFactors(int number){
        int count = 0;
        
        //First loop to count factors
        for(int i=1; i<=number; i++){
            if(number % i == 0){
                count++;
            }
        }
        
        //Initialize array with count
        int[] factors = new int[count];
        int index = 0;
        
        //Second loop to save factors
        for(int i=1; i<=number; i++){
            if(number % i == 0){
                factors[index++] = i;
            }
        }
        
        return factors;
    }
    
    //Method to find sum of factors
    public int findSum(int[] factors){
        int sum = 0;
        for(int factor : factors){
            sum += factor;
        }
        return sum;
    }
    
    //Method to find product of factors
    public int findProduct(int[] factors){
        int product = 1;
        for(int factor : factors){
            product *= factor;
        }
        return product;
    }
    
    //Method to find sum of squares of factors
    public int findSumOfSquares(int[] factors){
        int sumOfSquares = 0;
        for(int factor : factors){
            sumOfSquares += Math.pow(factor, 2);
        }
        return sumOfSquares;
    }
}
