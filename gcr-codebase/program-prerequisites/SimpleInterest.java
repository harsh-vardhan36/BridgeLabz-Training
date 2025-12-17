import java.util.Scanner;
class SimpleInterest{
	public static void main(String [] args) {
	Scanner in = new Scanner(System.in);
	System.out.print("Enter Principal amount: ");
	int principal = in.nextInt();
	System.out.print("Enter Rate amount: ");
	int Rate = in.nextInt();
	System.out.print("Enter Time amount: ");
	int Time = in.nextInt();
	in.close();
	int simpleInterest = ((principal*Rate*Time)/100);
	System.out.print(simpleInterest);
	
	
	
	
	}
}