import java.util.*;
 public class AvgofThreeNumber{
	public static void main(String [] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the First number: ");
	int First = in.nextInt();
	System.out.println("Enter the Second Number: ");
	int Second = in.nextInt();
	System.out.println("Enter the Third Number: ");
	int Third = in.nextInt();
	int Result = ((First+Second+Third)/3);
	System.out.println("The result is: "+Result);
	in.close();

	}
 }