import java.util.Scanner;

public class TrainReservationQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int seats = 5; // total available seats
        boolean running = true;

        while (running) {
            System.out.println("\n--- Train Reservation Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Check Availability");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (seats > 0) {
                        System.out.println("Ticket booked successfully!");
                        seats--; // reduce seat count
                        System.out.println("Remaining seats: " + seats);
                        if (seats == 0) {
                            System.out.println("No more seats available. Booking closed.");
                            break; // exits switch, but we’ll stop loop below
                        }
                    } else {
                        System.out.println("Sorry, train is fully booked.");
                    }
                    break;

                case 2:
                    System.out.println("Seats available: " + seats);
                    break;

                case 3:
                    System.out.println("Exiting system. Thank you!");
                    running = false; // stop loop
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Stop booking once seats reach zero
            if (seats == 0) {
                running = false;
            }
        }

        sc.close();
    }
}
