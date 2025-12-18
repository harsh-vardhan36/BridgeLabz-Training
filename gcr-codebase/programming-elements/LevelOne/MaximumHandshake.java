import java.util.Scanner;

//Creating a class MaximumHandshake to Calculate the Possible handshake.
public class MaximumHandshake {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking Input in variable 
        System.out.print("Enter the number of students");
		int numberOfStudents = input.nextInt();
		
		//Calculating the Possible Number of Handshake
		int maximumHandshake = ((numberOfStudents*(numberOfStudents -1))/2);
		
		//Displaying the Possible Handshakes.
		System.out.println(maximumHandshake);
		
    }
}
