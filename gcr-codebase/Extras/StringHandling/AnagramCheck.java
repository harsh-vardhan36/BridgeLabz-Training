// program to check whether two strings are anagrams
import java.util.Scanner;

public class AnagramCheck {

    // Method to check anagram
    public static boolean isAnagram(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        int[] freq = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i)]++;
            freq[str2.charAt(i)]--;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = in.nextLine();

        System.out.print("Enter second string: ");
        String str2 = in.nextLine();

        boolean result = isAnagram(str1, str2);

        if (result) {
            System.out.println("The strings are Anagrams");
        } else {
            System.out.println("The strings are NOT Anagrams");
        }

        in.close();
    }
}
