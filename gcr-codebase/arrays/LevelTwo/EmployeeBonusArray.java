//Program to calculate bonus of 10 employees based on their years of service

import java.util.*;

public class EmployeeBonusArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //  number of employees
        int numEmployee = 10;

        // Arrays to store employee details
        double[] oldSalary = new double[numEmployee];     // Stores original salary of each employee
        double[] yearsOfService = new double[numEmployee]; // Stores years of service of each employee
        double[] newSalaries = new double[numEmployee];   // Stores new salary after adding bonus
        double[] bonusAmounts = new double[numEmployee];  // Stores bonus amount for each employee

        // Variables to store totals
        double totalBonus = 0.0;      
        double totalOldSalary = 0.0;   
        double totalNewSalary = 0.0;  

        // Loop to take input and perform validation
        for (int i = 0; i < numEmployee; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");

            System.out.print("Enter your Salary: ");
            double salaryInput = in.nextDouble();

            System.out.print("Enter your Years of Service: ");
            double serviceInput = in.nextDouble();

            // Validation: salary must be > 0 and years of service must be >= 0
            if (salaryInput <= 0 || serviceInput < 0) {
                System.out.println("Invalid input! Please re-enter it.");
                i--; 
            }
			else {
                oldSalary[i] = salaryInput;
                yearsOfService[i] = serviceInput;
            }
        }

        // Loop to calculate bonus and new salary for each employee
        for (int i = 0; i < numEmployee; i++) {
            double bonusPercentage;

            // 5% bonus if service > 5 years, otherwise 2%
            if (yearsOfService[i] > 5) {
                bonusPercentage = 0.05;
            } else {
                bonusPercentage = 0.02;
            }

            // Calculating bonus and new salary
            bonusAmounts[i] = oldSalary[i] * bonusPercentage;
            newSalaries[i] = oldSalary[i] + bonusAmounts[i];

            // Finding totals
            totalBonus += bonusAmounts[i];
            totalOldSalary += oldSalary[i];
            totalNewSalary += newSalaries[i];
        }

        // Displaying the results
        System.out.println(" Totals :");
        System.out.println("Total Old Salary Paid: " + totalOldSalary);
        System.out.println("Total Bonus Paid: " + totalBonus);
        System.out.println("Total New Salary Payout: " + totalNewSalary);

        in.close();
    }
}
