///Utility class to perform various number checks.
import java.util.Scanner;

public class NumberChecker{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = in.nextInt();
        
        //Call methods
        int count = countDigits(number);
        int[] digits = storeDigits(number);
        int sum = sumOfDigits(digits);
        int sumSquares = sumOfSquares(digits);
        boolean isHarshad = isHarshadNumber(number, digits);
        int[][] frequency = digitFrequency(digits);
        
        //Display results
        System.out.println("Number: " + number);
        System.out.println("Count of digits: " + count);
        
        System.out.print("Digits array: ");
        for(int d : digits){
            System.out.print(d + " ");
        }
        System.out.println();
        
        System.out.println("Sum of digits: " + sum);
        System.out.println("Sum of squares of digits: " + sumSquares);
        System.out.println("Harshad Number? " + (isHarshad ? "Yes" : "No"));
        
        System.out.println("Digit Frequencies:");
        for(int i = 0; i < frequency.length; i++){
            if(frequency[i][1] > 0){
                System.out.println("Digit " + frequency[i][0] + " occurs " + frequency[i][1] + " times");
            }
        }
    }
    
    //Method to find count of digits
    public static int countDigits(int number){
        return String.valueOf(number).length();
    }
    
    //Method to store digits in an array
    public static int[] storeDigits(int number){
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];
        for(int i = 0; i < numStr.length(); i++){
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }
    
    //Method to find sum of digits
    public static int sumOfDigits(int[] digits){
        int sum = 0;
        for(int d : digits){
            sum += d;
        }
        return sum;
    }
    
    //Method to find sum of squares of digits
    public static int sumOfSquares(int[] digits){
        int sumSquares = 0;
        for(int d : digits){
            sumSquares += Math.pow(d, 2);
        }
        return sumSquares;
    }
    
    //Method to check Harshad number
    public static boolean isHarshadNumber(int number, int[] digits){
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }
    
    //Method to find frequency of each digit
    public static int[][] digitFrequency(int[] digits){
        int[][] freq = new int[10][2]; // 10 digits (0–9)
        
        //Initialize digit column
        for(int i = 0; i < 10; i++){
            freq[i][0] = i;
            freq[i][1] = 0;
        }
        
        //Count frequency
        for(int d : digits){
            freq[d][1]++;
        }
        
        return freq;
    }
}
