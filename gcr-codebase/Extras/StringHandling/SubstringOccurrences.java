// program to count occurrences of a substring in a string
import java.util.Scanner;

public class SubstringOccurrences {

    // Method to count substring occurrences
    public static int countOccurrences(String str, String sub) {
        int count = 0;

        for (int i = 0; i <= str.length() - sub.length(); i++) {
            int j;
            for (j = 0; j < sub.length(); j++) {
                if (str.charAt(i + j) != sub.charAt(j)) {
                    break;
                }
            }
            if (j == sub.length()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String mainString = in.nextLine();

        System.out.print("Enter the substring: ");
        String subString = in.nextLine();

        int occurrences = countOccurrences(mainString, subString);

        System.out.println("Occurrences: " + occurrences);

        in.close();
    }
}
