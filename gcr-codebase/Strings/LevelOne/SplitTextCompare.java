// Program to split text into words and compare with split() method
import java.util.*;

public class SplitTextCompare {

    // Creating a Method to find length of String without using length()
    public static int findLength(String text) {

        int count = 0;

        for (char ch : text.toCharArray()) {
            count++;
        }

        return count;
    }

    // Creating a Method to split text into words using charAt()
    public static String[] splitText(String text) {

        int len = findLength(text);

        // Step 1: Count number of words
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Step 2: Store indexes of spaces
        int[] spaceIndex = new int[wordCount + 1];
        int index = 1;
        spaceIndex[0] = -1;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[index++] = i;
            }
        }
        spaceIndex[index] = len;

        // Step 3: Extract words using indexes
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            String word = "";
            for (int j = spaceIndex[i] + 1; j < spaceIndex[i + 1]; j++) {
                word = word + text.charAt(j);
            }
            words[i] = word;
        }

        return words;
    }

    // Creating a Method to compare two String arrays
    public static boolean isArraySame(String[] arr1, String[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
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

        // Splitting using user-defined method
        String[] userResult = splitText(text);

        // Splitting using built-in split() method
        String[] builtInResult = text.split(" ");

        // Displaying user-defined split result
        System.out.println("Words using user-defined method:");
        for (int i = 0; i < userResult.length; i++) {
            System.out.println(userResult[i]);
        }

        // Displaying built-in split result
        System.out.println("Words using split() method:");
        for (int i = 0; i < builtInResult.length; i++) {
            System.out.println(builtInResult[i]);
        }

        // Comparing both results
        System.out.println(
            "Is both word arrays same: " +
            isArraySame(userResult, builtInResult)
        );
    }
}
