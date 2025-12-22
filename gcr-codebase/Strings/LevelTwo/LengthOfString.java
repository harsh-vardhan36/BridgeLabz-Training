//program to find the length of a string without using the length() methods.
import java.util.*;
public class LengthOfString{
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	
	//Taking Values from user.
	System.out.print("Enter the string: ");
	String text = in.nextLine();
	System.out.println("The number of count using length function: "+ text.length());
	
	//calling the checkStringLength methods.
	System.out.println("The number of count is: "+ checkStringLength(text));
	}

	public static int checkStringLength(String text){
	 int count = 0;
	 int index = 0;
	 try{
		while(true){
		text.charAt(index);
		count++;
		index++;
		}
	 }
	 catch(StringIndexOutOfBoundsException e ){
		 System.out.println("The given string count have finished.");
		 return count;
	 }
	}
}