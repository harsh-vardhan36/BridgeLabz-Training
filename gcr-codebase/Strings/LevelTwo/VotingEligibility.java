// program to take user input for the age and check whether the student can vote.
import java.util.Scanner;
public class VotingEligibility {

    // Method to generate random 2-digit ages for n students
    static int[] generateAges(int n) {
        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            // random 2-digit age between 10 and 99
            ages[i] = (int)(Math.random() * 90) + 10;
        }
        return ages;
    }

    // Method to check voting eligibility
    static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    // Method to display 2D array in tabular format
    static void displayTable(String[][] table) {
        System.out.println("\nAGE\tCAN VOTE");
        System.out.println("----------------");

        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = in.nextInt();

        int[] ages = generateAges(n);
        String[][] votingResult = checkVotingEligibility(ages);
        displayTable(votingResult);

        in.close();
    }
}
