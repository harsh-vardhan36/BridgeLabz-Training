// Program: Date Comparison Example Using LocalDate's isBefore(), isAfter(), and isEqual().

import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {

    // Method to compare two dates
    public static void compareDates(LocalDate date1, LocalDate date2) {
        if (date1.isBefore(date2)) {
            System.out.println("First date (" + date1 + ") is BEFORE second date (" + date2 + ")");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date (" + date1 + ") is AFTER second date (" + date2 + ")");
        } else if (date1.isEqual(date2)) {
            System.out.println("Both dates are EQUAL: " + date1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input format: yyyy-MM-dd
        System.out.print("Enter first date (yyyy-MM-dd): ");
        String input1 = sc.nextLine();
        LocalDate date1 = LocalDate.parse(input1);

        System.out.print("Enter second date (yyyy-MM-dd): ");
        String input2 = sc.nextLine();
        LocalDate date2 = LocalDate.parse(input2);

        // Compare dates using method
        compareDates(date1, date2);

        sc.close();
    }
}
