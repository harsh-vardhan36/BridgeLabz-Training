//program to find the bonus of employees whose year of service is more than 5 years.
import java.util.Scanner;
public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take salary input
        System.out.print("Enter your salary: ");
        double salary = input.nextDouble();

        // Take years of service input
        System.out.print("Enter your years of service: ");
        int yearsOfService = input.nextInt();

        // Checking eligibility and calculate bonus
        if (yearsOfService > 5) {
            double bonus = salary * 0.05;  // 5% bonus
            System.out.println("You are eligible for a bonus of: " + bonus);
        } else {
            System.out.println("No bonus. Years of service must be more than 5.");
        }

        input.close();
    }
}
