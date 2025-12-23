// Program to demonstrate IllegalArgumentException
import java.util.*;

public class IllegalArgumentDemo {

    // Creating a Method to generate Runtime Exception
    public static void generateException(String text) {

        // Setting start index greater than end index
        int start = 5;
        int end = 2;

        // This will generate a Runtime Exception and stop the program
        System.out.println(text.substring(start, end));
    }

    // Creating a Method to handle IllegalArgumentException
    public static void handleException(String text) {

        int start = 5;
        int end = 2;

        try {
            // Accessing substring with invalid arguments
            System.out.println(text.substring(start, end));
        }
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled");
        }
        catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }

    // Calling the main method
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter the string: ");
        String text = in.next();

        // Calling method to generate exception
        generateException(text);

        // Calling method to handle the Runtime Exception
        handleException(text);
    }
}
