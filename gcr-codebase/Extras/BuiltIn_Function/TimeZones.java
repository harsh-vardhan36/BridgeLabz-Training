import java.time.ZonedDateTime;
import java.time.ZoneId; 
import java.time.format.DateTimeFormatter; 
public class TimeZones{
	// Method to display current time for a given zone 
	public static void displayTime(String zoneName, String zoneId) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss z");
		ZonedDateTime time = ZonedDateTime.now(ZoneId.of(zoneId)); 
		System.out.println("Current Time in " + zoneName + ": " + time.format(formatter));
	} 
	public static void main(String[] args) { 
	// Call method for GMT 
	displayTime("GMT", "GMT");
	// Call method for IST
	displayTime("IST", "Asia/Kolkata");
	// Call method for PST 
	displayTime("PST", "America/Los_Angeles");
	} 
}