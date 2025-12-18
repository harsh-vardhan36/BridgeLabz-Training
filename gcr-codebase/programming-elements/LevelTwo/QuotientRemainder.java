import java.util.Scanner;

//Creating a class QuotientRemainder to Calculate the Quotient and Remainder of two numbers.
public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking Input in variable 
        System.out.print("Enter First Number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter Second Number: ");
        int number2 = sc.nextInt();

        // Calculating the quotient
        double quotient = number1 / number2;
		
		// Calculating the Remainder
        double remainder = number1 % number2;

        // Output
        System.out.println("The Quotient is "+quotient+ " and Reminder is "+ remainder +" of two number " + number1 + " and " +number2);
    }
}
