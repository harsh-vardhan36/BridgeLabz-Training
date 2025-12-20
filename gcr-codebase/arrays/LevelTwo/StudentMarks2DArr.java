//Program to calculate the Marks of students in Array.
import java.util.Scanner;
public class StudentMarks2DArr {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Taking number of students
        System.out.print("Enter number of students: ");
        int number = in.nextInt();

        //Creating 2D array for marks and other arrays
        double[][] marksData = new double[number][3];
        double[] percentage = new double[number];
        String[] grade = new String[number];

        // Input marks 
        for (int i = 0; i < number; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Physics marks: ");
            double physics = in.nextDouble();

            System.out.print("Enter Chemistry marks: ");
            double chemistry = in.nextDouble();

            System.out.print("Enter Maths marks: ");
            double maths = in.nextDouble();

            // Validation
            if (physics < 0 || physics > 100 ||
                chemistry < 0 || chemistry > 100 ||
                maths < 0 || maths > 100) {

                System.out.println("Invalid marks! Enter values between 0 and 100.");
                i--; 
                continue;
            }

            marksData[i][0] = physics;
            marksData[i][1] = chemistry;
            marksData[i][2] = maths;
        }

        //percentage and grade
        for (int i = 0; i < number; i++) {

            double total = marksData[i][0]
                         + marksData[i][1]
                         + marksData[i][2];

            percentage[i] = (total / 300) * 100;

            if (percentage[i] >= 90) {
                grade[i] = "A";
            } 
			else if (percentage[i] >= 75) {
                grade[i] = "B";
            } 
			else if (percentage[i] >= 60) {
                grade[i] = "C";
            } 
			else if (percentage[i] >= 40) {
                grade[i] = "D";
            }
			else {
                grade[i] = "Fail";
            }
        }

        // result
        for (int i = 0; i < number; i++) {
                    marksData[i][0],
                    marksData[i][1],
                    marksData[i][2],
                    percentage[i],
                    grade[i]);
        }

        in.close();
    }
}