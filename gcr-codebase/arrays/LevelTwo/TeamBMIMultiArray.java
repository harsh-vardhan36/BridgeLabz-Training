//Program to calculate BMI using a multi-dimensional array

import java.util.Scanner;
public class TeamBMIMultiArray {
    public static void main(String[] args) {
       
	   Scanner in = new Scanner(System.in);

        //Taking input for number of persons
        System.out.print("Enter number of persons in the team: ");
        int number = in.nextInt();

        //Multi-dimensional array: [person][0=weight, 1=height, 2=BMI]
        double[][] personData = new double[number][3];

        //Array to store weight status
        String[] weightStatus = new String[number];

        //Taking input for weight and height of each person
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Person " + (i + 1) + ":");

            //Validate weight input
            double weight;
            do {
                System.out.print("Weight (in kg): ");
                weight = in.nextDouble();
                if (weight <= 0) {
                    System.out.println("Invalid input! Please enter a positive value for weight.");
                }
            } while (weight <= 0);

            //Validate height input
            double height;
            do {
                System.out.print("Height (in meters): ");
                height = in.nextDouble();
                if (height <= 0) {
                    System.out.println("Invalid input! Please enter a positive value for height.");
                }
            } while (height <= 0);

            //Store weight and height in array
            personData[i][0] = weight;
            personData[i][1] = height;

            //Calculate BMI and store in array
            personData[i][2] = weight / (height * height);

            //Determine weight status
            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            }
			else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } 
			else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } 
			else {
                weightStatus[i] = "Obese";
            }
        }

        //Displaying results
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) +
                               " | Height: " + personData[i][1] + " m" +
                               " | Weight: " + personData[i][0] + " kg" +
                               " | BMI: " + String.format("%.2f", personData[i][2]) +
                               " | Status: " + weightStatus[i]);
        }

        in.close();
    }
}
