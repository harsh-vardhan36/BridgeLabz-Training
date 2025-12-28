import java.util.Scanner;

public class MetroSmartCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 200; // starting balance

        while (balance > 0) {
            System.out.print("Enter distance (or 0 to quit): ");
            int distance = sc.nextInt();

            if (distance == 0) break; // exit condition

            int fare = (distance <= 10) ? 20 : 40; // ternary operator
            if (balance >= fare) {
                balance -= fare;
                System.out.println("Fare deducted: " + fare);
                System.out.println("Remaining balance: " + balance);
            } else {
                System.out.println("Insufficient balance!");
                break;
            }
        }

        System.out.println("Journey ended. Final balance: " + balance);
    }
}
