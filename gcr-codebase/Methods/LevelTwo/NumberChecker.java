///Program to check positive/negative, even/odd for 5 numbers and compare first & last elements.
import java.util.Scanner;

public class NumberChecker{
    public static void main(String [] args){
    
        Scanner in = new Scanner(System.in);
        
        //Array to store 5 numbers
        int[] numbers = new int[5];
        
        //Taking input for 5 numbers
        for(int i = 0; i < numbers.length; i++){
            System.out.print("Enter number " + (i+1) + ": ");
            numbers[i] = in.nextInt();
        }
        
        //Loop through array and check conditions
        for(int i = 0; i < numbers.length; i++){
            if(isPositive(numbers[i])){
                if(isEven(numbers[i])){
                    System.out.println("Number " + numbers[i] + " is Positive and Even.");
                } else {
                    System.out.println("Number " + numbers[i] + " is Positive and Odd.");
                }
            } else {
                System.out.println("Number " + numbers[i] + " is Negative.");
            }
        }
        
        //Compare first and last element
        int result = compare(numbers[0], numbers[numbers.length - 1]);
        
        if(result == 0){
            System.out.println("First element " + numbers[0] + " and Last element " + numbers[numbers.length - 1] + " are Equal.");
        } else if(result == 1){
            System.out.println("First element " + numbers[0] + " is Greater than Last element " + numbers[numbers.length - 1] + ".");
        } else {
            System.out.println("First element " + numbers[0] + " is Less than Last element " + numbers[numbers.length - 1] + ".");
        }
    }
    
    //Method to check positive or negative
    public static boolean isPositive(int number){
        return number >= 0;
    }
    
    //Method to check even or odd
    public static boolean isEven(int number){
        return number % 2 == 0;
    }
    
    //Method to compare two numbers
    public static int compare(int number1, int number2){
        if(number1 > number2){
            return 1;
        } else if(number1 == number2){
            return 0;
        } else {
            return -1;
        }
    }
}
