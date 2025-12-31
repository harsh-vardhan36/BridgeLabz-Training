import java.util.Scanner;

public class FitnessChallengeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array to store push-up counts for 7 days
        int[] pushUps = new int[7];

        System.out.println("Enter push-up counts for 7 days (use 0 for rest days):");
        for (int i = 0; i < pushUps.length; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            pushUps[i] = sc.nextInt();
        }

        int total = 0;
        int activeDays = 0;

        // Use for-each loop to calculate total and average
        for (int count : pushUps) {
            if (count == 0) {
                // Skip rest days
                continue;
            }
            total += count;
            activeDays++;
        }

        double average = (activeDays > 0) ? (double) total / activeDays : 0;

        System.out.println("\n--- Weekly Fitness Report ---");
        System.out.println("Total push-ups: " + total);
        System.out.println("Active days: " + activeDays);
        System.out.println("Average push-ups per active day: " + average);

        sc.close();
    }
}
