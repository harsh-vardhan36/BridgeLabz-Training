//Program to store multiple values in an array and calculate their sum
import java.util.Scanner;
public class StoreValues {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;

        //Declaring index variable
        int index = 0;

        //Using infinite loop
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double num = in.nextDouble();

            if (num <= 0) {
                break;
            }

            if (index == 10) {
                break;
            }

            //Storing number in array and incrementing index
            numbers[index] = num;
            index++;
        }

        //Calculating total using another loop
        for (int i = 0; i < index; i++) {
            total = total + numbers[i];
        }

        //Displaying all numbers
        System.out.println("Numbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }

        System.out.println("Sum of all numbers: " + total);

        in.close();
    }
}
