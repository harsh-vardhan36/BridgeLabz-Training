import java.util.Scanner;

public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Festival Lucky Draw  ===");
        System.out.print("Enter number of visitors: ");
        int visitors = sc.nextInt();

        for (int i = 1; i <= visitors; i++) {
            System.out.print("Visitor " + i + ", draw your number: ");
            int number = sc.nextInt();

            // Check for invalid input
            if (number <= 0) {
                System.out.println("Invalid input. Skipping visitor " + i);
                continue;
            }

            // Check divisibility by 3 and 5
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println(" Congratulations! You win a gift!");
            } else {
                System.out.println("Better luck next time!");
            }
        }

        sc.close();
    }
}
