import java.util.Scanner;

public class CurrencyExchangeKiosk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double inrAmount, convertedAmount;
        int choice;
        char continueChoice;

        // Conversion rates (example values, can be updated)
        final double USD_RATE = 0.012;   // 1 INR = 0.012 USD
        final double EUR_RATE = 0.011;   // 1 INR = 0.011 EUR
        final double GBP_RATE = 0.0095;  // 1 INR = 0.0095 GBP

        System.out.println("=== Welcome to Currency Exchange Kiosk 💱 ===");

        // do-while ensures at least one conversion
        do {
            // Step 1: Input INR amount
            System.out.print("Enter amount in INR: ");
            inrAmount = sc.nextDouble();

            // Step 2: Choose target currency
            System.out.println("Choose target currency:");
            System.out.println("1. USD");
            System.out.println("2. EUR");
            System.out.println("3. GBP");
            System.out.print("Enter your choice (1-3): ");
            choice = sc.nextInt();

            // Step 3: Apply conversion using switch
            switch (choice) {
                case 1:
                    convertedAmount = inrAmount * USD_RATE;
                    System.out.printf("%.2f INR = %.2f USD%n", inrAmount, convertedAmount);
                    break;
                case 2:
                    convertedAmount = inrAmount * EUR_RATE;
                    System.out.printf("%.2f INR = %.2f EUR%n", inrAmount, convertedAmount);
                    break;
                case 3:
                    convertedAmount = inrAmount * GBP_RATE;
                    System.out.printf("%.2f INR = %.2f GBP%n", inrAmount, convertedAmount);
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }

            // Step 4: Ask if user wants another conversion
            System.out.print("Do you want another conversion? (Y/N): ");
            continueChoice = sc.next().charAt(0);

        } while (continueChoice == 'Y' || continueChoice == 'y');

        System.out.println("Thank you for using the Currency Exchange Kiosk!");
        sc.close();
    }
}
