//Program to check voting eligibility of 10 students based on age
import java.util.Scanner;
public class VotingEligibility {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Defining array of 10 integer elements
        int[] ages = new int[10];

        //Taking user input for ages
        System.out.println("Enter ages of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            ages[i] = in.nextInt();
        }

        //Checking voting eligibility
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];

            if (age < 0) {
                System.out.println("Invalid age entered: " + age);
            }
			else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            }
			else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }

        in.close();
    }
}
