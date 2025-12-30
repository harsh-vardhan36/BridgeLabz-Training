import java.util.Scanner;

public class SchoolBusAttendanceSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array of student names
        String[] students = {"Adarsh", "Harsh", "Neha", "Meena", "Sahil", 
                             "Suraj", "Rohit", "priya", "Vikas", "Anjali"};

        int presentCount = 0;
        int absentCount = 0;

        // Use for-each loop to ask attendance
        for (String student : students) {
            System.out.print("Is " + student + " present or absent? ");
            String status = sc.next();

            if (status.equalsIgnoreCase("Present")) {
                presentCount++;
            } else {
                absentCount++;
            }
        }

        System.out.println("Total Present: " + presentCount);
        System.out.println("Total Absent: " + absentCount);

        sc.close();
    }
}
