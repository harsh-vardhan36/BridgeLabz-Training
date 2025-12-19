// A program to check if a given date (month and day)
// falls in the Spring Season (March 20 to June 20).

public class SpringSeason {
    public static void main(String[] args) {
        
        // Read month and day from command line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Check if the date is in Spring Season
        boolean isSpring = 
            (month == 3 && day >= 20 && day <= 31) ||   // March 20 to March 31
            (month == 4 && day >= 1 && day <= 30)  ||   // April (whole month)
            (month == 5 && day >= 1 && day <= 31)  ||   // May (whole month)
            (month == 6 && day >= 1 && day <= 20);      // June 1 to June 20

        // Print result based on condition
        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
