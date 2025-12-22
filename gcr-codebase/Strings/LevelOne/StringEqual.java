//program to compare two strings using the charAT() and java built in string equals() method.
import java.util.*;
public class StringEqual{
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	
	//Taking Values from user.
	System.out.print("Enter 1st string: ");
	String first = in.nextLine();
	System.out.print("Enter 2nd string: ");
	String second = in.nextLine();
	
	//calling the checkstring methods.
	System.out.println("Is both string equals: "+checkStringEquals(first,second));
	
	}
	  public static boolean checkStringEquals(String first, String second){
		char store, value;
		boolean equals = false;
		boolean equalsUsing = false;
		if(first.length()!=second.length()) return equals;
			
		else if (first.length()==second.length()){
		  for(int i = 0; i<first.length()-1; i++){
			 store = first.charAt(i);
			 value = second.charAt(i);
			 if(store == value) equals = true;
			 else if(store != value) equals = false; return equals;
		  }
		 }
		//using  built-in function
		if(first.equals(second)) equalsUsing = true;
		else if(!first.equals(second)) return equalsUsing;
		
		//comparing both methods.
		if(equals == equalsUsing) return equals;
		else return equalsUsing;
	  }
}