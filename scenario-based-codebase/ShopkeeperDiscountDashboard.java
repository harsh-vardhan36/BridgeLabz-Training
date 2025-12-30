import java.util.Scanner;

public class ShopkeeperDiscountDashboard {
    // Constants for discount thresholds
    private static final double DISCOUNT_10 = 0.10;
    private static final double DISCOUNT_20 = 0.20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        double totalBill = 0;

        // Input item prices using for-loop
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter price of item " + i + ": ");
            double price = sc.nextDouble();
            totalBill += price;
        }

        // Apply discount using if-else
        double discount = 0;
        if (totalBill >= 5000) {
            discount = DISCOUNT_20;
        } else if (totalBill >= 2000) {
            discount = DISCOUNT_10;
        }

        double finalAmount = totalBill - (totalBill * discount);

        System.out.println("Total Bill: " + totalBill);
        System.out.println("Discount Applied: " + (discount * 100) + "%");
        System.out.println("Final Amount to Pay: " + finalAmount);

        sc.close();
    }
}
