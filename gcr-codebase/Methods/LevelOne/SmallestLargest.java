///Program to find the smallest and largest of 3 numbers.
import java.util.Scanner;
public class SmallestLargest{
    public static void main(String [] args){
    
        Scanner in = new Scanner(System.in);
        
        //Creating object of SmallestLargest
        SmallestLargest SL = new SmallestLargest();
        
        //Taking the numbers from user.
        System.out.print("Enter the first number: ");
        int number1 = in.nextInt();
        System.out.print("Enter the second number: ");
        int number2 = in.nextInt();
        System.out.print("Enter the third number: ");
        int number3 = in.nextInt();
        
        int[] result = SL.findSmallestAndLargest(number1, number2, number3);
        
        System.out.println("The Smallest number is " + result[0] + 
                           " and the Largest number is " + result[1]);
    }
    
    public static int[] findSmallestAndLargest(int number1, int number2, int number3){
        int smallest = number1;
        int largest = number1;
        
        if(number2 < smallest) smallest = number2;
        if(number3 < smallest) smallest = number3;
        
        if(number2 > largest) largest = number2;
        if(number3 > largest) largest = number3;
        
        return new int[]{smallest, largest};
    }
}
