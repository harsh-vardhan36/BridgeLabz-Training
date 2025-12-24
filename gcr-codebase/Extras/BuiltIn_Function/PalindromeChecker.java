// Program: Palindrome Checker 
import java.util.Scanner;
public class PalindromeChecker {

    // Function to take input from user
    public static String getInput(Scanner in) {
        System.out.print("Enter a string: ");
        return in.nextLine();
    }

    // Function to check if a string is palindrome
    public static boolean isPalindrome(String str) {
        // Normalize string: remove spaces and convert to lowercase
        str = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; 
            }
            left++;
            right--;
        }
        return true; 
    }

    // Function to display result
    public static void displayResult(String str, boolean result) {
        if (result) {
            System.out.println("\"" + str + "\" is a PALINDROME.");
        } else {
            System.out.println("\"" + str + "\" is NOT a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Step 1: Input
        String input = getInput(in);

        // Step 2: Check palindrome
        boolean result = isPalindrome(input);

        // Step 3: Display result
        displayResult(input, result);

        in.close();
    }
}
