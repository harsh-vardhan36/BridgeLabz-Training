import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    public static void main(String[] args) {
        // Step 1: Get current date
        LocalDate currentDate = LocalDate.now();

        // Step 2: Define formatters
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Step 3: Display formatted dates
        System.out.println("Format 1 (dd/MM/yyyy): " + currentDate.format(format1));
        System.out.println("Format 2 (yyyy-MM-dd): " + currentDate.format(format2));
        System.out.println("Format 3 (EEE, MMM dd, yyyy): " + currentDate.format(format3));
    }
}
