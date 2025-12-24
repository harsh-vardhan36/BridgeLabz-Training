// program to compare two strings lexicographically without built-in methods
import java.util.Scanner;

public class LexicographicalCompare {

    // Method to compare strings
    public static int compareStrings(String str1, String str2) {

        int minLength = str1.length() < str2.length() ? str1.length() : str2.length();

        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.charAt(i) - str2.charAt(i);
            }
        }
        // all characters matched so far
        return str1.length() - str2.length();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = in.nextLine();

        System.out.print("Enter second string: ");
        String str2 = in.nextLine();

        int result = compareStrings(str1, str2);

        if (result < 0) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        }
        else if (result > 0) {
            System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order");
        }
        else {
            System.out.println("Both strings are equal");
        }

        in.close();
    }
}
