///Program to generate PCM scores, calculate total, average, percentage, and assign grades.
import java.util.*;

public class StudentScorecard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input: number of students
        System.out.print("Enter number of students: ");
        int n = in.nextInt();

        // Step 1: Generate PCM scores
        int[][] scores = generateScores(n);

        // Step 2: Calculate total, average, percentage
        double[][] results = calculateResults(scores);

        // Step 3: Display scorecard
        displayScorecard(scores, results);
    }

    // Method to generate random 2-digit PCM scores
    public static int[][] generateScores(int n) {
        int[][] scores = new int[n][3]; // Physics, Chemistry, Math
        for (int i = 0; i < n; i++) {
            scores[i][0] = (int)(Math.random() * 50) + 50; // Physics: 50–99
            scores[i][1] = (int)(Math.random() * 50) + 50; // Chemistry: 50–99
            scores[i][2] = (int)(Math.random() * 50) + 50; // Math: 50–99
        }
        return scores;
    }

    // Method to calculate total, average, percentage
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3]; // total, average, percentage
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    // Method to display scorecard with grades and remarks
    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.printf("%-6s %-8s %-10s %-8s %-8s %-10s %-10s %-10s %-20s\n",
                          "ID", "Physics", "Chemistry", "Math", "Total", "Average", "Percent", "Grade", "Remarks");
        System.out.println("---------------------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            String grade = "";
            String remark = "";
            double percent = results[i][2];

            if (percent >= 80) {
                grade = "A"; remark = "Level 4, above agency-normalized standards";
            } else if (percent >= 70) {
                grade = "B"; remark = "Level 3, at agency-normalized standards";
            } else if (percent >= 60) {
                grade = "C"; remark = "Level 2, approaching standards";
            } else if (percent >= 50) {
                grade = "D"; remark = "Level 1, below standards";
            } else if (percent >= 40) {
                grade = "E"; remark = "Level 1-, too below standards";
            } else {
                grade = "R"; remark = "Remedial standards";
            }

            System.out.printf("%-6d %-8d %-10d %-8d %-8.0f %-10.2f %-10.2f %-10s %-20s\n",
                              (i+1), scores[i][0], scores[i][1], scores[i][2],
                              results[i][0], results[i][1], results[i][2], grade, remark);
        }
    }
}
