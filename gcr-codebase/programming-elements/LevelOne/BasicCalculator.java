import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        // Step 1: Create Scanner object to take input
        Scanner input = new Scanner(System.in);

        // Step 2: Take user input for two numbers
        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();

        // Step 3: Perform arithmetic operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;  // assuming number2 != 0

        // Step 4: Print results
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "  + number1 + " and " + number2 + " is "  + addition + ", " + subtraction + ", " + multiplication + ", and " + division);
    }
}
