//Problem 1: The Coffee Counter Chronicles
import java.util.Scanner; 

public class CoffeeCounterChronicles {

    static final double GST_RATE = 0.05; 

    // Returns coffee price based on coffee type
    public static double getCoffeePrice(String coffeeType) {
        switch (coffeeType) {
            case "espresso":
                return 119;
            case "americano":
                return 149;
            case "cappuccino":
                return 169;
            default:
                return -1; // Invalid coffee type
        }
    }

    // Calculates total bill including GST
    public static double calculateTotalBill(double price, int quantity) {
        double baseAmount = price * quantity;
        System.out.println("Base Amount (without GST): Rs. " + baseAmount);
        double gst = baseAmount * GST_RATE;
        System.out.println("GST (5%): Rs. " + gst);
        return baseAmount + gst;
    }

    // Program execution starts here
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Loop to take multiple orders
        while (true) {
            System.out.println("\nWelcome to Coffee Counter Chronicles!");
            System.out.println("Available coffee types: espresso (Rs.120), americano (Rs.150), cappuccino (Rs.180) \n Type 'exit' to quit.");
            String coffeeType = scanner.next().toLowerCase();

            if (coffeeType.equals("exit")) break; // Stops the program

            double price = getCoffeePrice(coffeeType);

            if (price == -1) {
                System.out.println("Invalid coffee type!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            double totalBill = calculateTotalBill(price, quantity);

            System.out.println("Total Bill (including 5% GST): Rs. " + totalBill);

            System.out.println("Enjoy your " + coffeeType + "!");
        }

        System.out.println("Thank you for ordering, please visit again!");
        scanner.close(); //Closing the Scanner Object
    }
}

