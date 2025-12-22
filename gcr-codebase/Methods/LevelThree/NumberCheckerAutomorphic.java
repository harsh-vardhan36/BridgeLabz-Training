///Utility class to perform various number checks.
import java.util.Scanner;

public class NumberChecker{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = in.nextInt();
        
        //Call methods
        boolean isPrime = isPrime(number);
        boolean isNeon = isNeon(number);
        boolean isSpy = isSpy(number);
        boolean isAutomorphic = isAutomorphic(number);
        boolean isBuzz = isBuzz(number);
        
        //Display results
        System.out.println("Number: " + number);
        System.out.println("Prime Number? " + (isPrime ? "Yes" : "No"));
        System.out.println("Neon Number? " + (isNeon ? "Yes" : "No"));
        System.out.println("Spy Number? " + (isSpy ? "Yes" : "No"));
        System.out.println("Automorphic Number? " + (isAutomorphic ? "Yes" : "No"));
        System.out.println("Buzz Number? " + (isBuzz ? "Yes" : "No"));
    }
    
    //Method to check Prime Number
    public static boolean isPrime(int number){
        if(number <= 1) return false;
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
    
    //Method to check Neon Number
    public static boolean isNeon(int number){
        int square = number * number;
        int sum = 0;
        while(square > 0){
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }
    
    //Method to check Spy Number
    public static boolean isSpy(int number){
        int sum = 0, product = 1;
        int temp = number;
        while(temp > 0){
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }
    
    //Method to check Automorphic Number
    public static boolean isAutomorphic(int number){
        int square = number * number;
        String numStr = String.valueOf(number);
        String squareStr = String.valueOf(square);
        return squareStr.endsWith(numStr);
    }
    
    //Method to check Buzz Number
    public static boolean isBuzz(int number){
        return (number % 7 == 0) || (number % 10 == 7);
    }
}
