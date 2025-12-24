// program to find the longest word in a sentence
import java.util.Scanner;

public class LongestWordInSentence {

    // Method to find longest word
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longest = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }
        return longest;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = in.nextLine();

        String longestWord = findLongestWord(input);

        System.out.println("Longest word: " + longestWord);

        in.close();
    }
}
