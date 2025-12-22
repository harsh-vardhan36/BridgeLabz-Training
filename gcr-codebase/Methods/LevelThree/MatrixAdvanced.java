///Program to perform transpose, determinant, and inverse of a matrix.
import java.util.*;

public class MatrixAdvanced {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input: matrix size
        System.out.print("Enter matrix size (2 or 3): ");
        int size = in.nextInt();

        int[][] matrix = generateMatrix(size, size);

        System.out.println("\nOriginal Matrix:");
        displayMatrix(matrix);

        // Transpose
        int[][] transpose = transposeMatrix(matrix);
        System.out.println("Transpose:");
        displayMatrix(transpose);

        // Determinant
        int det = (size == 2) ? determinant2x2(matrix) : determinant3x3(matrix);
        System.out.println("Determinant: " + det);

        // Inverse (only for 2x2)
        if (size == 2 && det != 0) {
            double[][] inverse = inverse2x2(matrix);
            System.out.println("Inverse:");
            displayMatrix(inverse);
        } else if (size == 2) {
            System.out.println("Inverse not possible (determinant is 0)");
        } else {
            System.out.println("Inverse for 3x3 not implemented yet.");
        }
    }

    // Method to generate random matrix
    public static int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = (int)(Math.random() * 10); // values 0–9
        return matrix;
    }

    // Method to display int matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.printf("%4d", val);
            System.out.println();
        }
    }

    // Method to display double matrix
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row)
                System.out.printf("%8.2f", val);
            System.out.println();
        }
    }

    // Method to transpose matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                transposed[j][i] = matrix[i][j];
        return transposed;
    }

    // Method to find determinant of 2x2 matrix
    public static int determinant2x2(int[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    // Method to find determinant of 3x3 matrix
    public static int determinant3x3(int[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    // Method to find inverse of 2x2 matrix
    public static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1] / (double)det;
        inv[0][1] = -m[0][1] / (double)det;
        inv[1][0] = -m[1][0] / (double)det;
        inv[1][1] = m[0][0] / (double)det;
        return inv;
    }
}
