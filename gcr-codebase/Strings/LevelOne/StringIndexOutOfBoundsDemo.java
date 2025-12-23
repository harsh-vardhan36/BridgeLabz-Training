// Program to demonstrate StringIndexOutOfBoundsException
import java.util.*;

public class StringIndexOutOfBoundsDemo {

    // Creating a Method to generate StringIndexOutOfBoundsException
    public static void generateException(String text) {

        // Accessing index beyond string length
        // This will generate Runtime Exception
        System.out.println(text.charAt(text.length()));
    }

    // Creating a Method to handle StringIndexOutOfBoundsException
    public static void handleException(String text) {

        try {
            // Accessing index beyond string length
            System.out.println(text.charAt(text.length()));
        }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled");
        }
    }

    // Calling the main method
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter the string: ");
        String text = in.next();
		
        // Calling method to handle the exception
        handleException(text);
    }
}
