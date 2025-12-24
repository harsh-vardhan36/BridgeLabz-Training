// program to reverse a string without using built-in reverse functions
import java.util.Scanner;

public class ReverseString {

    // Method to reverse string
    public static String reverseString(String str) {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }
        return reversed;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = in.nextLine();

        String result = reverseString(input);

        System.out.println("Reversed String: " + result);

        in.close();
    }
}
