import java.util.Scanner;

public class BusRouteDistanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stopDistance = 5; // distance between stops in km
        int totalDistance = 0;
        char choice;

        System.out.println("=== Bus Route Distance Tracker ===");

        while (true) {
            totalDistance += stopDistance;
            System.out.println("Bus reached next stop. Total distance: " + totalDistance + " km");

            System.out.print("Do you want to get off? (Y/N): ");
            choice = sc.next().charAt(0);

            if (choice == 'Y' || choice == 'y') {
                System.out.println("You got off the bus after traveling " + totalDistance + " km.");
                break; // exit loop
            }
        }

        sc.close();
    }
}
