import java.util.Scanner;

//Creating a class FindDistanceInYardMiles to Find the distance in yards and miles distance will be given in feet.
public class FindDistanceInYardMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking Input in variable 
        System.out.print("Enter the distance in Feet: ");
		int feet = input.nextInt();
				
		//Calculating the distance in yards and Miles. 1 yard = 3 feet. 
		double  DistanceInYards = (feet/3);
		double  DistanceInMiles = (feet/1760);
			
		//Displaying the Distance in Yards and Miles.
		System.out.println("The distance in yards is " +DistanceInYards+ " while the distance in miles is "+ DistanceInMiles);
		
    }
}
