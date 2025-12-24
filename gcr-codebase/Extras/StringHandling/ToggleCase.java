// program to toggle the case of characters in a string
import java.util.Scanner;

public class ToggleCase {

    // Method to toggle case
    public static String toggleCase(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                result = result + (char)(ch + 32); // convert to lowercase
            }
            else if (ch >= 'a' && ch <= 'z') {
                result = result + (char)(ch - 32); // convert to uppercase
            }
            else {
                result = result + ch; // non-alphabet character
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = in.nextLine();

        String toggled = toggleCase(input);

        System.out.println("Toggled String: " + toggled);

        in.close();
    }
}
