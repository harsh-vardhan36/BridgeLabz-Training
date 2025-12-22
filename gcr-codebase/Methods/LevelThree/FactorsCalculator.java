///Program to find factors of a number and perform various tasks.
import java.util.Scanner;

public class FactorsCalculator{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = in.nextInt();
        
        //Find factors
        int[] factors = findFactors(number);
        
        //Display factors
        System.out.print("Factors of " + number + ": ");
        for(int f : factors){
            System.out.print(f + " ");
        }
        System.out.println();
        
        //Greatest factor
        int greatest = findGreatestFactor(factors);
        System.out.println("Greatest factor: " + greatest);
        
        //Sum of factors
        int sum = sumOfFactors(factors);
        System.out.println("Sum of factors: " + sum);
        
        //Product of factors
        long product = productOfFactors(factors);
        System.out.println("Product of factors: " + product);
        
        //Product of cubes of factors
        long productCubes = productOfCubes(factors);
        System.out.println("Product of cubes of factors: " + productCubes);
    }
    
    //Method to find factors of a number
    public static int[] findFactors(int number){
        int count = 0;
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                count++;
            }
        }
        
        int[] factors = new int[count];
        int index = 0;
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                factors[index++] = i;
            }
        }
        return factors;
    }
    
    //Method to find greatest factor
    public static int findGreatestFactor(int[] factors){
        int max = factors[0];
        for(int f : factors){
            if(f > max){
                max = f;
            }
        }
        return max;
    }
    
    //Method to find sum of factors
    public static int sumOfFactors(int[] factors){
        int sum = 0;
        for(int f : factors){
            sum += f;
        }
        return sum;
    }
    
    //Method to find product of factors
    public static long productOfFactors(int[] factors){
        long product = 1;
        for(int f : factors){
            product *= f;
        }
        return product;
    }
    
    //Method to find product of cubes of factors
    public static long productOfCubes(int[] factors){
        long product = 1;
        for(int f : factors){
            product *= Math.pow(f, 3);
        }
        return product;
    }
}
