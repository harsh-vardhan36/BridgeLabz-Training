// Program to demonstrate NumberFormatException
import java.util.*;

public class NumberFormatDemo {

    // Creating a Method to generate NumberFormatException
    public static void generateException(String text) {

        // Trying to convert text into number
        // This will generate NumberFormatException if text is not numeric
        int number = Integer.parseInt(text);

        System.out.println("Number is: " + number);
    }

    // Creating a Method to handle NumberFormatException
    public static void handleException(String text) {

        try {
            // Trying to convert text into number
            int number = Integer.parseInt(text);
            System.out.println("Number is: " + number);
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled");
        }
        catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }

    // Calling the main method
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter the text: ");
        String text = in.next();

        // Calling method to generate exception
        generateException(text);

        // Calling method to handle the Runtime Exception
        handleException(text);
    }
}
