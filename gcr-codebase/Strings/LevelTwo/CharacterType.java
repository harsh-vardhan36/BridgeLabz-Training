// program to find vowels and consonants in a string  and display the character type - Vowel, Consonant, or Not a Letter
import java.util.Scanner;

public class CharacterType {

    // Method to check character type
    static String checkChar(char ch) {

        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);
        }

        // Check if letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method to create 2D array of character and its type
    static String[][] findCharacterType(String text) {

        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }

        String[][] table = new String[count][2];

        for (int i = 0; i < count; i++) {
            char ch = text.charAt(i);
            table[i][0] = String.valueOf(ch);
            table[i][1] = checkChar(ch);
        }
        return table;
    }

    // Method to display 2D array in tabular format
    static void displayTable(String[][] table) {
        System.out.println("\nCHARACTER\tTYPE");
        System.out.println("-------------------------");

        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = in.nextLine();

        String[][] result = findCharacterType(text);
        displayTable(result);

        in.close();
    }
}
