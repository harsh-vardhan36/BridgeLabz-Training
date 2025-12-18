import java.util.Scanner;

//Creating a class PurchaseCalculator to Calculate the Total price.
public class PurchaseCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking Input in variable 
        System.out.print("Enter unit price (INR): ");
        double unitPrice = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        // Calculation
        double totalPrice = unitPrice * quantity;

        // Output
        System.out.println("The total purchase price is INR " + totalPrice +" if the quantity " + quantity + " and unit price is INR " + unitPrice);
    }
}
