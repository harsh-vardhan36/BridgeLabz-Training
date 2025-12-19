//Program to Find the Yougest and Tallest among three friends.
import java.util.Scanner;
public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        //Take age and height of the three friends
        System.out.print("Enter age of Amar: ");
		int ageAmar=input.nextInt();
        System.out.print("Enter Height of Amar: ");
        double heightAmar=input.nextDouble();
        System.out.println("Enter age of Akbar:");
        int ageAkbar = input.nextInt();
		System.out.print("Enter height of Akbar:");
        double heightAkbar = input.nextDouble();
        System.out.print("Enter age of Anthony: ");
        int ageAnthony=input.nextInt();
		System.out.println("Enter height of Anthony: ");
        double heightAnthony= input.nextDouble();

        // Find and display the youngest friend
        if (ageAmar<ageAkbar && ageAmar<ageAnthony){
            System.out.println("Amar is the youngest");
        }
		else if(ageAkbar<ageAmar && ageAkbar<ageAnthony){
            System.out.println("Akbar is the youngest");
        }
		else{
            System.out.println("Anthony is the youngest");
        }

        // Find the display the friend with the largest height
        if (heightAmar>heightAkbar && heightAmar>heightAnthony){
            System.out.println("Amar is the tallest");
        }
		else if(heightAkbar>heightAmar && heightAkbar>heightAnthony){
            System.out.println("Akbar is the tallest");
        }
		else{
            System.out.println("Anthony is the tallest");
        }

        input.close();

    }
}