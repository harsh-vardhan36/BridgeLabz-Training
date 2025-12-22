///Program to calculate bonus and new salary for 10 employees based on years of service.
import java.util.*;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        // Step 1: Generate random salary and years of service
        double[][] employeeData = generateEmployeeData(10);

        // Step 2: Calculate bonus and new salary
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);

        // Step 3: Display results in tabular format
        displaySalaryTable(employeeData, updatedData);
    }

    // Method to generate random salary and years of service
    public static double[][] generateEmployeeData(int size) {
        double[][] data = new double[size][2]; // [salary, years of service]
        for (int i = 0; i < size; i++) {
            data[i][0] = (int)(Math.random() * 90000) + 10000; // 5-digit salary
            data[i][1] = (int)(Math.random() * 11); // 0 to 10 years of service
        }
        return data;
    }

    // Method to calculate bonus and new salary
    public static double[][] calculateBonusAndNewSalary(double[][] data) {
        double[][] updated = new double[data.length][2]; // [bonus, new salary]
        for (int i = 0; i < data.length; i++) {
            double salary = data[i][0];
            int years = (int)data[i][1];
            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            updated[i][0] = bonus;
            updated[i][1] = salary + bonus;
        }
        return updated;
    }

    // Method to display salary table and totals
    public static void displaySalaryTable(double[][] oldData, double[][] newData) {
        double totalOld = 0, totalNew = 0, totalBonus = 0;

        System.out.printf("%-10s %-12s %-10s %-10s %-12s\n", "Emp#", "Old Salary", "Service", "Bonus", "New Salary");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < oldData.length; i++) {
            double oldSalary = oldData[i][0];
            int years = (int)oldData[i][1];
            double bonus = newData[i][0];
            double newSalary = newData[i][1];

            System.out.printf("%-10d %-12.2f %-10d %-10.2f %-12.2f\n", (i+1), oldSalary, years, bonus, newSalary);

            totalOld += oldSalary;
            totalBonus += bonus;
            totalNew += newSalary;
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s %-12.2f %-10s %-10.2f %-12.2f\n", "TOTAL", totalOld, "", totalBonus, totalNew);
    }
}
