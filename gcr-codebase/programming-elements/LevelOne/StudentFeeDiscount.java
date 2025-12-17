import java.util.Scanner;

public class StudentFeeDiscount {
    public static void main(String[] args) {
        // Step 1: Create Scanner object to take input
        Scanner input = new Scanner(System.in);

        // Step 2: Take user input for fee
        System.out.print("Enter the student fee (INR): ");
        double fee = input.nextDouble();

        // Step 3: Take user input for discount percent
        System.out.print("Enter the discount percent: ");
        double discountPercent = input.nextDouble();

        // Step 4: Compute discount amount
        double discount = (fee * discountPercent) / 100;

        // Step 5: Compute final discounted fee
        double finalFee = fee - discount;

        // Step 6: Print results
        System.out.println("The discount amount is INR " + discount +
                           " and final discounted fee is INR " + finalFee);
    }
}
