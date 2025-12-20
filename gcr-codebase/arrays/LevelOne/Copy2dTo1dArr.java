//Program to create a 2D array and copy it into a 1D array
import java.util.Scanner;
public class Copy2dTo1dArr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking user input for rows and columns
        System.out.print("Enter number of rows: ");
        int rows = in.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = in.nextInt();

        //Creating 2D array (Matrix)
        int[][] matrix = new int[rows][cols];

        //Taking input for matrix elements
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        //Creating 1D array of size rows*cols
        int[] array = new int[rows * cols];

        //Copying elements from 2D array to 1D array
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }

        //Displaying 1D array
        System.out.println("Elements of the 1D array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        in.close();
    }
}
