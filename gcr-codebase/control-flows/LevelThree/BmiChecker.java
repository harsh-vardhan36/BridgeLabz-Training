//Program to check BMI status
import java.util.Scanner;
public class BmiChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking weight and height as input
        System.out.println("Enter your weight in kg");
        double weight = in.nextInt();
        System.out.print("Enter your height in cm");
        double height = in.nextInt();

        //Converting height in meters
        double heightInMeters = height / 100;

        //Calculating BMI = weight / (height * height)
        double BMI = weight / (heightInMeters * heightInMeters);

        //Determining BMI status using if-else-if ladder
        if (BMI >= 40) {
            System.out.println("With " + BMI + " you are Obese");
        } else if (BMI >= 25.0 && BMI < 40) {
            System.out.println("With " + BMI + " you are Overweight");
        } else if (BMI > 18.5 && BMI < 25) {
            System.out.println("With " + BMI + " you are Normal");
        } else {
            System.out.println("With " + BMI + " you are UnderWeight");
        }

        in.close();
    }
}
