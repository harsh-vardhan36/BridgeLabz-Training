// program to find vowels and consonants in a string
import java.util.Scanner;
public class VowelConsonantCount {

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

    // Method to find vowels and consonants using charAt()
    static int[] findVowelConsonant(String text) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; ; i++) {
            try {
                char ch = text.charAt(i);
                String result = checkChar(ch);

                if (result.equals("Vowel")) {
                    vowelCount++;
                } else if (result.equals("Consonant")) {
                    consonantCount++;
                }
            } catch (Exception e) {
                break; // end of string
            }
        }
        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = in.nextLine();

        int[] count = findVowelConsonant(text);

        System.out.println("\nVowels Count     : " + count[0]);
        System.out.println("Consonants Count : " + count[1]);

        in.close();
    }
}
