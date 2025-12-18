import java.util.Scanner;

//Creating a class IntOperation to perform various operation on 3 variables.
public class DoubleOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking Input in variable 
        System.out.print("Enter First Number: ");
        double a = sc.nextDouble();

        System.out.print("Enter Second Number: ");
        double b = sc.nextDouble();
		
		System.out.print("Enter Third Number: ");
        double c = sc.nextDouble();

        // Performing the operation three times
        double operation1 = a+b*c;
		double operation2 = a*b+c;  
		double operation3 = c+a/b;
		

        // Output
        System.out.println("The results of Int Operations are "+operation1+"," +operation2 + " and " +operation3);
    }
}
