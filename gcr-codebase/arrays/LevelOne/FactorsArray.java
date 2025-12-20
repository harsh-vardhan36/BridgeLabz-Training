//Program to find factors of a number and store them in an array
import java.util.Scanner;
public class FactorsArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Taking input for number
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        //Initializing maxFactor and factors array
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        //Finding factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (index == maxFactor) {
                    //Doubling size of array
                    maxFactor = maxFactor * 2;
                    int[] temp = new int[maxFactor];

                    //Copying old elements to temp
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    factors = temp;
                }
                factors[index] = i;
                index++;
            }
        }

        //Displaying factors
        System.out.println("Factors of " + number + " are:");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();

        in.close();
    }
}
