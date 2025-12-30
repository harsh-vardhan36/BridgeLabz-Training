import java.util.Scanner;

public class PhoneRechargeSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 0;
        boolean continueRecharge = true;

        while (continueRecharge) {
            System.out.print("Enter your mobile operator (Airtel/Jio/VI): ");
            String operator = sc.next();

            System.out.print("Enter recharge amount: ");
            double amount = sc.nextDouble();

            // Switch to display offers
            switch (operator.toLowerCase()) {
                case "airtel":
                    System.out.println("Offer: 1.5GB/day for 28 days");
                    break;
                case "jio":
                    System.out.println("Offer: Unlimited calls + 2GB/day for 28 days");
                    break;
                case "vi":
                    System.out.println("Offer: Weekend data rollover + 1GB/day");
                    break;
                default:
                    System.out.println("Invalid operator. No offers available.");
            }

            // Update balance
            balance += amount;
            System.out.println("Recharge successful. Current balance: " + balance);

            // Ask if user wants to recharge again
            System.out.print("Do you want to recharge again? (yes/no): ");
            String choice = sc.next();
            if (choice.equalsIgnoreCase("no")) {
                continueRecharge = false;
            }
        }

        System.out.println("Final balance: " + balance);
        sc.close();
    }
}
