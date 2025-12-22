///Program to display calendar for a given month and year.
import java.util.Scanner;

public class CalendarDisplay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Taking input for month and year
        System.out.print("Enter month (1-12): ");
        int month = in.nextInt();
        System.out.print("Enter year: ");
        int year = in.nextInt();

        // Get month name
        String monthName = getMonthName(month);

        // Get number of days in the month
        int days = getDaysInMonth(month, year);

        // Get first day of the month
        int firstDay = getFirstDayOfMonth(month, year);

        // Display calendar header
        System.out.println("\n" + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // First loop: indentation before 1st day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Second loop: print days with formatting
        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0) {
                System.out.println(); // move to next line after Saturday
            }
        }
        System.out.println(); // final line break
    }

    // Method to get month name
    public static String getMonthName(int month) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[month - 1];
    }

    // Method to get number of days in a month
    public static int getDaysInMonth(int month, int year) {
        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    // Method to check leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to get first day of the month using Gregorian calendar algorithm
    public static int getFirstDayOfMonth(int month, int year) {
        int d = 1; // first day of the month
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0; // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
    }
}
