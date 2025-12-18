import java.util.Scanner;

//Creating a class IntOperation to perform various operation on 3 variables.
public class IntOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking Input in variable 
        System.out.print("Enter First Number: ");
        int a = sc.nextInt();

        System.out.print("Enter Second Number: ");
        int b = sc.nextInt();
		
		System.out.print("Enter Third Number: ");
        int c = sc.nextInt();

        // Performing the operation three times
        int operation1 = a+b*c;
		int operation2 = a*b+c;  
		int operation3 = c+a/b;
		

        // Output
        System.out.println("The results of Int Operations are "+operation1+"," +operation2 + " and " +operation3);
    }
}
