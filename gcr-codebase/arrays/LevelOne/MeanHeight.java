//Program to find the mean height of players in a football team
import java.util.Scanner;
public class MeanHeight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Defining array of size 11 to store heights
        double[] heights = new double[11];

        //Taking input values from user
        System.out.println("Enter the heights of 11 players (in cm):");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = in.nextDouble();
        }

        //Calculating sum of all elements
        double sum = 0.0;
        for (int i = 0; i < heights.length; i++) {
            sum = sum + heights[i];
        }

        //Calculating mean using formula
        double mean = sum / heights.length;

        //Displaying mean height
        System.out.println("The mean height of the football team is: " + mean + " cm");

        in.close();
    }
}
