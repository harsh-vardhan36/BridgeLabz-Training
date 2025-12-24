// program to remove a specific character from a string
import java.util.Scanner;

public class RemoveSpecificCharacter {

    // Method to remove character
    public static String removeCharacter(String str, char removeChar) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != removeChar) {
                result = result + ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = in.nextLine();

        System.out.print("Enter character to remove: ");
        char removeChar = in.next().charAt(0);

        String modified = removeCharacter(input, removeChar);

        System.out.println("Modified String: \"" + modified + "\"");

        in.close();
    }
}
