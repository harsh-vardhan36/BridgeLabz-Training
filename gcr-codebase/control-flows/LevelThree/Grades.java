//Program to compute grade levels based on marks with remarks.
import java.util.Scanner;
public class Grades {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking marks as input
        System.out.println("Enter your marks in Math, Physics, and Chemistry:");
        int math = in.nextInt();
        int physics = in.nextInt();
        int chemistry = in.nextInt();

        //Computing percentage
        int percentage = (math + physics + chemistry) / 3;

        //Checking grade levels using if-else conditions
        if (percentage >= 80) {
            System.out.println("With " + percentage + " you got Level-4, above agency-normalized standards");
        } else if (percentage >= 70 && percentage < 80) {
            System.out.println("With " + percentage + " you got Level-3, at agency-normalized standards");
        } else if (percentage >= 60 && percentage < 70) {
            System.out.println("With " + percentage + " you got Level-2, below, but approaching agency-normalized standards");
        } else if (percentage >= 50 && percentage < 60) {
            System.out.println("With " + percentage + " you got Level-1, well below agency-normalized standards");
        } else if (percentage >= 40 && percentage < 50) {
            System.out.println("With " + percentage + " you got Level-1, too below agency-normalized standards");
        } else {
            System.out.println("With " + percentage + " : remedial standards");
        }

        in.close();
    }
}
