import java.util.Scanner;

public class ResultGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[5];
        int total = 0;

        // Input marks
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks for subject " + (i+1) + ": ");
            marks[i] = sc.nextInt();
            total += marks[i];
        }

        // Calculate average
        int average = total / 5;

        // Assign grade using switch
        switch (average / 10) { // divide to simplify ranges
            case 10: case 9: case 8: // 80–100
                System.out.println("Grade: A");
                break;
            case 7: case 6: // 60–79
                System.out.println("Grade: B");
                break;
            case 5: case 4: // 40–59
                System.out.println("Grade: C");
                break;
            default:
                System.out.println("Grade: Fail");
        }
    }
}
