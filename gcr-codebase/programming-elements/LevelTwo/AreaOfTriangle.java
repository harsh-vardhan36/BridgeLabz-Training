import java.util.Scanner;

//Creating a class AreaOfTriangle to Calculate the Area of the triangle.
public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking Input in variable 
        System.out.print("Enter the base of Triangle: ");
		double base = input.nextDouble();
		
		System.out.print("Enter the height of Triangle: ");
		double height = input.nextDouble();
		
		//Calculating the Area of Triangle in Centimeter.
		double areaInCm = (1.0/2*base*height);
		
		//Converting the Area of Triangle in Inches.
		 double areaInInches = (areaInCm*0.3937);
		
		//Displaying the Area of Triangle.
		System.out.println("The Area of the triangle in sq in is "+areaInInches +" and sq cm is "+areaInCm );
		
    }
}
