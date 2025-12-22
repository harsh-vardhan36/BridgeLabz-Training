///Program to find the roots of a Quadratic Equation ax^2 + bx + c.
import java.util.Scanner;

public class Quadratic{
    public static void main(String [] args){
    
        Scanner in = new Scanner(System.in);
        
        //Creating object of Quadratic
        Quadratic Q = new Quadratic();
        
        //Taking input for coefficients
        System.out.print("Enter value of a: ");
        double a = in.nextDouble();
        System.out.print("Enter value of b: ");
        double b = in.nextDouble();
        System.out.print("Enter value of c: ");
        double c = in.nextDouble();
        
        double[] roots = Q.findRoots(a, b, c);
        
        //Displaying results
        if(roots.length == 2){
            System.out.println("The roots of the quadratic equation are: " + roots[0] + " and " + roots[1]);
        } else if(roots.length == 1){
            System.out.println("The root of the quadratic equation is: " + roots[0]);
        } else {
            System.out.println("The quadratic equation has no real roots.");
        }
    }
    
    //Method to find roots of quadratic equation
    public double[] findRoots(double a, double b, double c){
        //Calculate discriminant (delta)
        double delta = Math.pow(b, 2) - (4 * a * c);
        
        if(delta > 0){
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if(delta == 0){
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            //No real roots
            return new double[]{};
        }
    }
}
