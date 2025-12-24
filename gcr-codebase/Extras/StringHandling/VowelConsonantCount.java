import java.util.Scanner;

public class VowelConsonantCount {

    // Method to check vowel
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i'
            || ch == 'o' || ch == 'u';
    }

    // Method to count vowels
    public static int countVowels(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z' && isVowel(ch)) {
                count++;
            }
        }
        return count;
    }

    // Method to count consonants
    public static int countConsonants(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z' && !isVowel(ch)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = in.nextLine().toLowerCase();

        int vowels = countVowels(input);
        int consonants = countConsonants(input);

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
	in.close();
}
