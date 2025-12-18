import java.util.Scanner;

//Creating a class SideOfSquare to Calculate the Side of the Square by its perimeter.
public class  {
    public static vSideOfSquareoid main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking Input in variable 
        System.out.print("Enter the perimeter of Square: ");
		double perimeter = input.nextDouble();
				
		//Calculating the Side, as perimeter = 4 * Sides.
		double sideOfSquare = (perimeter/4);
			
		//Displaying the Side of Square.
		System.out.println("The length of the side is " + sideOfSquare+ " whose perimeter is " +perimeter );
		
    }
}
