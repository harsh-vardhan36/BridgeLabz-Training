///Program to perform matrix addition, subtraction, and multiplication.
import java.util.*;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Input: dimensions
        System.out.print("Enter number of rows: ");
        int rows = in.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = in.nextInt();

        // Generate two random matrices
        int[][] A = generateMatrix(rows, cols);
        int[][] B = generateMatrix(rows, cols);

        // Display matrices
        System.out.println("\nMatrix A:");
        displayMatrix(A);
        System.out.println("Matrix B:");
        displayMatrix(B);

        // Addition
        int[][] sum = addMatrices(A, B);
        System.out.println("Addition (A + B):");
        displayMatrix(sum);

        // Subtraction
        int[][] diff = subtractMatrices(A, B);
        System.out.println("Subtraction (A - B):");
        displayMatrix(diff);

        // Multiplication (only if cols of A == rows of B)
        if (A[0].length == B.length) {
            int[][] product = multiplyMatrices(A, B);
            System.out.println("Multiplication (A × B):");
            displayMatrix(product);
        } else {
            System.out.println("Multiplication not possible: Columns of A ≠ Rows of B");
        }
    }

    // Method to generate random matrix
    public static int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int)(Math.random() * 10); // values 0–9
            }
        }
        return matrix;
    }

    // Method to display matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }

    // Method to add matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Method to subtract matrices
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    // Method to multiply matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = B[0].length;
        int common = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
}
