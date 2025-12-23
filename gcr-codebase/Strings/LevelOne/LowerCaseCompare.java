// Program to convert text to lowercase using charAt() and compare with toLowerCase()
import java.util.*;

public class LowerCaseCompare {

    // Creating a Method to convert text to Lowercase using charAt()
    public static String convertToLower(String text) {

        String lowerText = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Checking if character is uppercase (A–Z)
            if (ch >= 'A' && ch <= 'Z') {
                // Converting uppercase to lowercase using ASCII difference
                ch = (char)(ch + 32);
            }

            lowerText = lowerText + ch;
        }

        return lowerText;
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
        String userLower = convertToLower(text);
        System.out.println("Lowercase using charAt(): " + userLower);

        // Using built-in toLowerCase() method
        String builtInLower = text.toLowerCase();
        System.out.println("Lowercase using toLowerCase(): " + builtInLower);

        // Comparing both results
        System.out.println(
            "Is both lowercase strings same: " +
            isStringSame(userLower, builtInLower)
        );
    }
}
