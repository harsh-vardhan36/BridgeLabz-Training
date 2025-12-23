// Program to return all characters in a String and compare with toCharArray()
import java.util.*;

public class CharArrayCompare {

    // Creating a Method to return characters without using toCharArray()
    public static char[] getCharacters(String text) {

        // Creating a character array of string length
        char[] chars = new char[text.length()];

        // Storing characters using charAt()
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }

        return chars;
    }

    // Creating a Boolean Method to compare two character arrays
    public static boolean isCharArraySame(char[] arr1, char[] arr2) {

        // Checking length first
        if (arr1.length != arr2.length) {
            return false;
        }

        // Comparing each character
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    // Calling the main method
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter the string: ");
        String text = in.next();

        // Calling user-defined method
        char[] userResult = getCharacters(text);

        // Calling built-in toCharArray() method
        char[] builtInResult = text.toCharArray();

        // Displaying characters returned by user-defined method
        System.out.print("Characters using user-defined method: ");
        for (int i = 0; i < userResult.length; i++) {
            System.out.print(userResult[i] + " ");
        }
        System.out.println();

        // Displaying characters returned by built-in method
        System.out.print("Characters using toCharArray(): ");
        for (int i = 0; i < builtInResult.length; i++) {
            System.out.print(builtInResult[i] + " ");
        }
        System.out.println();

        // Comparing both arrays
        System.out.println(
            "Is both character arrays same: " +
            isCharArraySame(userResult, builtInResult)
        );
    }
}
