//Program to find the youngest and tallest among Amar, Akbar, and Anthony
import java.util.Scanner;
public class FriendsComparison {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		
        int[] ages = new int[3];
        int[] heights = new int[3];

        //Defining names array for easy reference
        String[] names = {"Amar", "Akbar", "Anthony"};

        //Taking user input for age and height
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age of " + names[i] + ": ");
            ages[i] = in.nextInt();

            System.out.println("Enter height of " + names[i] + " (in cm): ");
            heights[i] = in.nextInt();
        }

        //Finding youngest friend
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }

        //Finding tallest friend
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        //Displaying results
        System.out.println("\n--- Results ---");
        System.out.println("The youngest friend is " + names[youngestIndex] + " with age " + ages[youngestIndex] + " years.");
        System.out.println("The tallest friend is " + names[tallestIndex] + " with height " + heights[tallestIndex] + " cm.");

        in.close();
    }
}
