// program to check the spring season
import java.util*;

public class SpringSeason {
    // Method to check Spring Season
    public static boolean isSpringSeason(int month, int day) {
        // March 20 to March 31
        if (month == 3 && day >= 20 && day <= 31) {
            return true;
        }
        // April (entire month)
        else if (month == 4 && day >= 1 && day <= 30) {
            return true;
        }
        // May (entire month)
        else if (month == 5 && day >= 1 && day <= 31) {
            return true;
        }
        // June 1 to June 20
        else if (month == 6 && day >= 1 && day <= 20) {
            return true;
        }
        return false;
    }
    // Main method
    public static void main(String[] args) {
        // Check if command-line arguments are provided
        if (args.length != 2) {
            System.out.println("Please provide month and day as command line arguments");
            return;
        }
        // Read month and day from command line
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
		
        // Check Spring Season
        if (isSpringSeason(month, day)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}