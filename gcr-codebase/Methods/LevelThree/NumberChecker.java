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
        boolean isDuck = isDuckNumber(digits);
        boolean isArmstrong = isArmstrongNumber(digits, number);
        int[] largestTwo = findLargestTwo(digits);
        int[] smallestTwo = findSmallestTwo(digits);
        
        //Display results
        System.out.println("Number: " + number);
        System.out.println("Count of digits: " + count);
        
        System.out.print("Digits array: ");
        for(int d : digits){
            System.out.print(d + " ");
        }
        System.out.println();
        
        System.out.println("Duck Number? " + (isDuck ? "Yes" : "No"));
        System.out.println("Armstrong Number? " + (isArmstrong ? "Yes" : "No"));
        System.out.println("Largest digit: " + largestTwo[0] + ", Second Largest digit: " + largestTwo[1]);
        System.out.println("Smallest digit: " + smallestTwo[0] + ", Second Smallest digit: " + smallestTwo[1]);
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
    
    //Method to check Duck Number
    public static boolean isDuckNumber(int[] digits){
        for(int d : digits){
            if(d == 0){
                return true; // Duck number has at least one zero
            }
        }
        return false;
    }
    
    //Method to check Armstrong Number
    public static boolean isArmstrongNumber(int[] digits, int number){
        int n = digits.length;
        int sum = 0;
        for(int d : digits){
            sum += Math.pow(d, n);
        }
        return sum == number;
    }
    
    //Method to find largest and second