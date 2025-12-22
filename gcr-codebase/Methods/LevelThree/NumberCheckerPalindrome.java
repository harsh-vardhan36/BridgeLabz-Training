///Utility class to perform various number checks.
import java.util.Scanner;
import java.util.Arrays;

public class NumberChecker{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = in.nextInt();
        
        //Call methods
        int count = countDigits(number);
        int[] digits = storeDigits(number);
        int[] reversed = reverseDigits(digits);
        boolean arraysEqual = compareArrays(digits, reversed);
        boolean isPalindrome = isPalindrome(digits);
        boolean isDuck = isDuckNumber(digits);
        
        //Display results
        System.out.println("Number: " + number);
        System.out.println("Count of digits: " + count);
        
        System.out.print("Digits array: ");
        for(int d : digits){
            System.out.print(d + " ");
        }
        System.out.println();
        
        System.out.print("Reversed digits array: ");
        for(int d : reversed){
            System.out.print(d + " ");
        }
        System.out.println();
        
        System.out.println("Are original and reversed arrays equal? " + (arraysEqual ? "Yes" : "No"));
        System.out.println("Palindrome Number? " + (isPalindrome ? "Yes" : "No"));
        System.out.println("Duck Number? " + (isDuck ? "Yes" : "No"));
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
    
    //Method to reverse digits array
    public static int[] reverseDigits(int[] digits){
        int[] reversed = new int[digits.length];
        for(int i = 0; i < digits.length; i++){
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }
    
    //Method to compare two arrays
    public static boolean compareArrays(int[] arr1, int[] arr2){
        return Arrays.equals(arr1, arr2);
    }
    
    //Method to check palindrome
    public static boolean isPalindrome(int[] digits){
        int[] reversed = reverseDigits(digits);
        return compareArrays(digits, reversed);
    }
    
    //Method to check Duck Number (contains at least one zero)
    public static boolean isDuckNumber(int[] digits){
        for(int d : digits){
            if(d == 0){
                return true;
            }
        }
        return false;
    }
}
