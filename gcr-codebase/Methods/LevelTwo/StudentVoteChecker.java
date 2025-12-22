//Program to check if 10 students can vote based on their age.
import java.util.Scanner;

public class StudentVoteChecker{
    public static void main(String [] args){
    
        Scanner in = new Scanner(System.in);
        
        //Creating object of StudentVoteChecker
        StudentVoteChecker svc = new StudentVoteChecker();
        
        //Array to store ages of 10 students
        int[] ages = new int[10];
        
        //Loop to take input and check voting eligibility
        for(int i = 0; i < ages.length; i++){
            System.out.print("Enter age of student " + (i+1) + ": ");
            ages[i] = in.nextInt();
            
            boolean canVote = svc.canStudentVote(ages[i]);
            
            if(canVote){
                System.out.println("Student " + (i+1) + " with age " + ages[i] + " CAN vote.");
            } else {
                System.out.println("Student " + (i+1) + " with age " + ages[i] + " CANNOT vote.");
            }
        }
    }
    
    //Method to check if student can vote
    public boolean canStudentVote(int age){
        //Validate negative age
        if(age < 0){
            return false;
        }
        //Check if age >= 18
        if(age >= 18){
            return true;
        } else {
            return false;
        }
    }
}
