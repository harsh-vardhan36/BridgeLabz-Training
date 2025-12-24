// program to replace a word in a sentence without using built-in replace method
import java.util.Scanner;

public class ReplaceWordInSentence {

    // Method to replace word
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String result = "";
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                result = result + newWord;
            } else {
                result = result + words[i];
            }

            if (i < words.length - 1) {
                result = result + " ";
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = in.nextLine();

        System.out.print("Enter word to replace: ");
        String oldWord = in.nextLine();

        System.out.print("Enter new word: ");
        String newWord = in.nextLine();

        String modifiedSentence = replaceWord(sentence, oldWord, newWord);

        System.out.println("Modified Sentence: " + modifiedSentence);

        in.close();
    }
}
