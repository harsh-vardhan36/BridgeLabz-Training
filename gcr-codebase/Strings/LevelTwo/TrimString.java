//  program to trim the leading and trailing spaces from a string .
import java.util.Scanner;
public class TrimString {

    // Method to find start and end index after trimming spaces
    static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = 0;

        // Find length without using length()
        try {
            while (true) {
                text.charAt(end);
                end++;
            }
        } catch (Exception e) {
            end = end - 1;
        }

        // Trim leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    static String createSubstring(String text, int start, int end) {
        String result = "";

        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    static boolean compareStrings(String s1, String s2) {
        int i = 0;

        try {
            while (true) {
                if (s1.charAt(i) != s2.charAt(i))
                    return false;
                i++;
            }
        } catch (Exception e) {
        }

        try {
            s2.charAt(i);
            return false;
        } catch (Exception e) {
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = in.nextLine();

        int[] indexes = findTrimIndexes(text);
        String trimmedText = createSubstring(text, indexes[0], indexes[1]);

        String builtInTrim = text.trim();
        boolean isSame = compareStrings(trimmedText, builtInTrim);

        System.out.println("\nTrimmed Text (Custom)  : [" + trimmedText + "]");
        System.out.println("Trimmed Text (Built-in): [" + builtInTrim + "]");
        System.out.println("Are both equal?        : " + isSame);

        in.close();
    }
}
