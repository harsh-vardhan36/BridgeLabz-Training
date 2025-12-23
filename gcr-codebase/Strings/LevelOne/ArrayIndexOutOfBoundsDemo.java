// Program to demonstrate ArrayIndexOutOfBoundsException
import java.util.*;

public class ArrayIndexOutOfBoundsDemo {

    // Creating a Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {

        // Accessing index beyond array length
        // This will generate Runtime Exception and stop the program
        System.out.println(names[names.length]);
    }

    // Creating a Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] names) {

        try {
            // Accessing index beyond array length
            System.out.println(names[names.length]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled");
        }
        catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }

    // Calling the main method
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Taking array size from user
        System.out.print("Enter number of names: ");
        int size = in.nextInt();

        // Creating array of names
        String[] names = new String[size];

        // Taking names as input
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = in.next();
        }

        // Calling method to generate exception
         generateException(names);

        // Calling method to handle the Runtime Exception
        handleException(names);
    }
}
