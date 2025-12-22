///Program to calculate BMI of 10 members and display their height, weight, BMI, and status.
import java.util.Scanner;

public class BMICalculator{
    public static void main(String [] args){
    
        Scanner in = new Scanner(System.in);
        
        //2D array: 10 rows (members), 3 columns (weight, height, BMI)
        double[][] members = new double[10][3];
        
        //Taking input for weight and height
        for(int i = 0; i < members.length; i++){
            System.out.print("Enter weight (kg) of member " + (i+1) + ": ");
            members[i][0] = in.nextDouble();
            
            System.out.print("Enter height (cm) of member " + (i+1) + ": ");
            members[i][1] = in.nextDouble();
        }
        
        //Calculate BMI for each member
        calculateBMI(members);
        
        //Get BMI status for each member
        String[] status = getBMIStatus(members);
        
        //Display results
        System.out.println("\n--- BMI Report ---");
        for(int i = 0; i < members.length; i++){
            System.out.println("Member " + (i+1) + ": " +
                               "Weight = " + members[i][0] + " kg, " +
                               "Height = " + members[i][1] + " cm, " +
                               "BMI = " + members[i][2] + ", " +
                               "Status = " + status[i]);
        }
    }
    
    //Method to calculate BMI and populate array
    public static void calculateBMI(double[][] members){
        for(int i = 0; i < members.length; i++){
            double weight = members[i][0];
            double heightCm = members[i][1];
            double heightM = heightCm / 100.0; //convert cm to meters
            double bmi = weight / (heightM * heightM);
            members[i][2] = bmi;
        }
    }
    
    //Method to determine BMI status
    public static String[] getBMIStatus(double[][] members){
        String[] status = new String[members.length];
        
        for(int i = 0; i < members.length; i++){
            double bmi = members[i][2];
            
            if(bmi <= 18.4){
                status[i] = "Underweight";
            } else if(bmi >= 18.5 && bmi <= 24.9){
                status[i] = "Normal";
            } else if(bmi >= 25.0 && bmi <= 39.9){
                status[i] = "Overweight";
            } else if(bmi >= 40.0){
                status[i] = "Obese";
            }
        }
        
        return status;
    }
}
