public class DigitalWatchSimulation {
    public static void main(String[] args) {
        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                System.out.printf("%02d:%02d\n", hour, minute);

                // Stop at 13:00 (simulate power cut)
                if (hour == 13 && minute == 0) {
                    System.out.println("Power cut! Simulation stopped.");
                    break; // exits inner loop
                }
            }
            if (hour == 13) {
                break; // exits outer loop too
            }
        }
    }
}
