// Program to demonstrate NullPointerException
import java.util.*;

public class NullPointerDemonstrate {

    // Creating a Method to generate NullPointerException
    public static void generateException() {

        String text = null; // initializing string to null

        // This will generate NullPointerException
        System.out.println(text.length());
    }

    // Creating a Method to handle NullPointerException
    public static void handleException() {

        String text = null; // initializing string to null

        try {
            System.out.println(text.length());
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException handled");
        }
    }

    // Calling the main method
    public static void main(String[] args) {

        // Calling method to generate exception
        generateException();

        // Refactored code to handle the exception
        handleException();
    }
}
