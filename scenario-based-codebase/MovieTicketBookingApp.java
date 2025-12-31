import java.util.Scanner;

public class MovieTicketBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Movie Ticket Booking ---");
            System.out.print("Enter movie type (1.Action, 2.Comedy, 3.Drama): ");
            int movieChoice = sc.nextInt();

            String movieType;
            switch (movieChoice) {
                case 1: movieType = "Action"; break;
                case 2: movieType = "Comedy"; break;
                case 3: movieType = "Drama"; break;
                default: movieType = "Unknown"; break;
            }

            System.out.print("Enter seat type (gold/silver): ");
            String seatType = sc.next();

            int price = 0;
            if (seatType.equalsIgnoreCase("gold")) {
                price = 300;
            } else if (seatType.equalsIgnoreCase("silver")) {
                price = 200;
            } else {
                System.out.println("Invalid seat type!");
                continue; // skip this booking
            }

            System.out.print("Do you want snacks? (yes/no): ");
            String snack = sc.next();
            if (snack.equalsIgnoreCase("yes")) {
                price += 100; // add snack cost
            }

            System.out.println("Booking confirmed: " + movieType + " | Seat: " + seatType + " | Total: ₹" + price);

            System.out.print("Do you want to book another ticket? (yes/no): ");
            String again = sc.next();
            if (again.equalsIgnoreCase("no")) {
                running = false;
            }
        }

        sc.close();
