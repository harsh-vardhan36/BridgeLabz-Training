// Program to convert text to uppercase using charAt() and compare with toUpperCase()
import java.util.*;

public class UpperCaseCompare {

    // Creating a Method to convert text to Uppercase using charAt()
    public static String convertToUpper(String text) {

        String upperText = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Checking if character is lowercase (a–z)
            if (ch >= 'a' && ch <= 'z') {
                // Converting lowercase to uppercase using ASCII difference
                ch = (char)(ch - 32);
            }

            upperText = upperText + ch;
        }

        return upperText;
    }

    // Creating a Boolean Method to compare two strings using charAt()
    public static boolean isStringSame(String text1, String text2) {

        if (text1.length() != text2.length()) {
            return false;
        }

        for (int i = 0; i < text1.length(); i++) {
            if (text1.charAt(i) != text2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    // Calling the main method
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Taking complete text input from user
        System.out.print("Enter the text: ");
        String text = in.nextLine();

        // Calling user-defined method to convert text
        String userUpper = convertToUpper(text);
        System.out.println("Uppercase using charAt(): " + userUpper);

        // Using built-in toUpperCase() method
        String builtInUpper = text.toUpperCase();
        System.out.println("Uppercase using toUpperCase(): " + builtInUpper);

        // Comparing both results
        System.out.println(
            "Is both uppercase strings same: " +
            isStringSame(userUpper, builtInUpper)
        );
    }
}
