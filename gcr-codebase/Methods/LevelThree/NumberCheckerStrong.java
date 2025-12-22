///Utility class to perform various number checks.
import java.util.Scanner;

public class NumberChecker{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = in.nextInt();
        
        //Call methods
        boolean isPerfect = isPerfectNumber(number);
        boolean isAbundant = isAbundantNumber(number);
        boolean isDeficient = isDeficientNumber(number);
        boolean isStrong = isStrongNumber(number);
        
        //Display results
        System.out.println("Number: " + number);
        System.out.println("Perfect Number? " + (isPerfect ? "Yes" : "No"));
        System.out.println("Abundant Number? " + (isAbundant ? "Yes" : "No"));
        System.out.println("Deficient Number? " + (isDeficient ? "Yes" : "No"));
        System.out.println("Strong Number? " + (isStrong ? "Yes" : "No"));
    }
    
    //Method to check Perfect Number
    public static boolean isPerfectNumber(int number){
        if(number <= 0) return false;
        int sum = sumOfProperDivisors(number);
        return sum == number;
    }
    
    //Method to check Abundant Number
    public static boolean isAbundantNumber(int number){
        if(number <= 0) return false;
        int sum = sumOfProperDivisors(number);
        return sum > number;
    }
    
    //Method to check Deficient Number
    public static boolean isDeficientNumber(int number){
        if(number <= 0) return false;
        int sum = sumOfProperDivisors(number);
        return sum < number;
    }
    
    //Helper method to find sum of proper divisors
    public static int sumOfProperDivisors(int number){
        int sum = 0;
        for(int i = 1; i <= number/2; i++){
            if(number % i == 0){
                sum += i;
            }
        }
        return sum;
    }
    
    //Method to check Strong Number
    public static boolean isStrongNumber(int number){
        int temp = number;
        int sum = 0;
        while(temp > 0){
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }
    
    //Helper method to calculate factorial
    public static int factorial(int n){
        int fact = 1;
        for(int i = 1; i <= n; i++){
            fact *= i;
        }
        return fact;
    }
}
