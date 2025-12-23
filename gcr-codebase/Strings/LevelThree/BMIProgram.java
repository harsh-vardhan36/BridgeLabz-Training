// Program to calculate the BMI of 10 persons using 2D array

import java.util.Scanner;

public class BMIProgram {

    // Method to calculate BMI and Status for one person
    static String[] calculateBMI(double weight, double heightCm) {

        double heightMeter = heightCm / 100;
        double bmi = weight / (heightMeter * heightMeter);

        String status;

        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[] {
                String.format("%.2f", bmi),
                status
        };
    }

    // Method to process height & weight array and return result array
    static String[][] processBMI(double[][] data) {

        String[][] result = new String[10][4];

        for (int i = 0; i < 10; i++) {

            double weight = data[i][0];
            double height = data[i][1];

            String[] bmiData = calculateBMI(weight, height);

            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = bmiData[0];
            result[i][3] = bmiData[1];
        }

        return result;
    }

    // Method to display result in tabular format
    static void displayResult(String[][] result) {

        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");

        for (int i = 0; i < 10; i++) {
            System.out.println(
                    result[i][0] + "\t\t" +
                    result[i][1] + "\t\t" +
                    result[i][2] + "\t\t" +
                    result[i][3]
            );
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1));

            System.out.print("Enter Weight (kg): ");
            data[i][0] = in.nextDouble();

            System.out.print("Enter Height (cm): ");
            data[i][1] = in.nextDouble();
        }

        String[][] result = processBMI(data);
        displayResult(result);

        in.close();
    }
}
