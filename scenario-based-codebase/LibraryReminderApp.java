import java.util.Scanner;

public class LibraryReminderApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fineRate = 5; // ₹5 per day late

        for (int i = 1; i <= 5; i++) {
            System.out.println("\n--- Book " + i + " ---");
            System.out.print("Enter due date (in days): ");
            int dueDate = sc.nextInt();

            System.out.print("Enter return date (in days): ");
            int returnDate = sc.nextInt();

            if (returnDate > dueDate) {
                int daysLate = returnDate - dueDate;
                int fine = daysLate * fineRate;
                System.out.println("Book " + i + " is late by " + daysLate + " days. Fine: ₹" + fine);
            } else {
                System.out.println("Book " + i + " returned on time. No fine.");
            }
        }

        sc.close();
    }
}
