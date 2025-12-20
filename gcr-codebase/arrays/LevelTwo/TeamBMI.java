//Program to calculate BMI of team members and display their status

import java.util.Scanner;

public class TeamBMI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking input for number of persons
        System.out.print("Enter number of persons in the team: ");
        int n = in.nextInt();

        //Defining arrays to store values
        double[] weights = new double[n];       // Stores weight of each person
        double[] heights = new double[n];       // Stores height of each person (in meters)
        double[] bmiValues = new double[n];     // Stores BMI of each person
        String[] status = new String[n];        // Stores weight status of each person

        //Taking input for weight and height of each person
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Person " + (i + 1) + ":");

            System.out.print("Weight (in kg): ");
            weights[i] = in.nextDouble();

            System.out.print("Height (in meters): ");
            heights[i] = in.nextDouble();
        }

        //Calculating BMI and weight status
        for (int i = 0; i < n; i++) {
            bmiValues[i] = weights[i] / (heights[i] * heights[i]); // BMI formula

            //Determining status based on BMI ranges
            if (bmiValues[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmiValues[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmiValues[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        //Displaying results
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1) +
                               " | Height: " + heights[i] + " m" +
                               " | Weight: " + weights[i] + " kg" +
                               " | BMI: " + String.format("%.2f", bmiValues[i]) +
                               " | Status: " + status[i]);
        }

        in.close();
    }
}
