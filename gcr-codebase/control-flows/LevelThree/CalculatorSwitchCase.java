//Program to create a calculator using switch...case
import java.util.Scanner;
public class CalculatorSwitchCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking first number as input
        System.out.print("Enter first number: ");
        double first = in.nextDouble();

        //Taking second number as input
        System.out.print("Enter second number: ");
        double second = in.nextDouble();

        //Taking operator as input
        System.out.print("Enter operator (+, -, *, /): ");
        String op = in.next();

        //Declaring variable to store result
        double result = 0;

        switch (op) {
            case "+":
                //Performing addition
                result = first + second;
                System.out.println("Result: " + result);
                break;

            case "-":
                //Performing subtraction
                result = first - second;
                System.out.println("Result: " + result);
                break;

            case "*":
                //Performing multiplication
                result = first * second;
                System.out.println("Result: " + result);
                break;

            case "/":
                //Performing division
                if (second != 0) {
                    result = first / second;
                    System.out.println("Result: " + result);
                } 
				else {
                    System.out.println("Division by zero is not allowed.");
                }
                break;

            default:
                //Handling invalid operator
                System.out.println("Invalid Operator");
        }

        in.close();
    }
}
