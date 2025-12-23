// program to take input marks of students in 3 subjects.
public class StudentScoreCard {
    // Generate random 2-digit PCM scores
    static int[][] generatePCMScores(int students) {
        int[][] pcm = new int[students][3];

        for (int i = 0; i < students; i++) {
            pcm[i][0] = (int)(Math.random() * 90) + 10; // Physics
            pcm[i][1] = (int)(Math.random() * 90) + 10; // Chemistry
            pcm[i][2] = (int)(Math.random() * 90) + 10; // Maths
        }
        return pcm;
    }

    // Calculate total, average, percentage
    static double[][] calculateScores(int[][] pcm) {
        double[][] result = new double[pcm.length][3];

        for (int i = 0; i < pcm.length; i++) {
            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            result[i][0] = total;
            result[i][1] = Math.round(avg * 100) / 100.0;
            result[i][2] = Math.round(percent * 100) / 100.0;
        }
        return result;
    }

    // Calculate grade based on percentage
    static String[] calculateGrade(double[][] scores) {
        String[] grade = new String[scores.length];

        for (int i = 0; i < scores.length; i++) {
            double p = scores[i][2];

            if (p >= 80)
                grade[i] = "A";
            else if (p >= 70)
                grade[i] = "B";
            else if (p >= 60)
                grade[i] = "C";
            else if (p >= 50)
                grade[i] = "D";
            else if (p >= 40)
                grade[i] = "E";
            else
                grade[i] = "R";
        }
        return grade;
    }

    // Display scorecard
    static void displayScoreCard(int[][] pcm, double[][] scores, String[] grade) {

        System.out.println("\nSTU\tPHY\tCHE\tMAT\tTOTAL\tAVG\tPERC\tGRADE");

        for (int i = 0; i < pcm.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                    pcm[i][0] + "\t" +
                    pcm[i][1] + "\t" +
                    pcm[i][2] + "\t" +
                    (int)scores[i][0] + "\t" +
                    scores[i][1] + "\t" +
                    scores[i][2] + "\t" +
                    grade[i]
            );
        }
    }

    public static void main(String[] args) {

        int students = 5; 

        int[][] pcm = generatePCMScores(students);
        double[][] scores = calculateScores(pcm);
        String[] grade = calculateGrade(scores);

        displayScoreCard(pcm, scores, grade);
    }
}
