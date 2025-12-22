///Program to generate six-digit OTP numbers and validate uniqueness.
import java.util.*;

public class OTPGenerator{
    public static void main(String [] args){
        
        //Array to store 10 OTPs
        int[] otps = new int[10];
        
        //Generate 10 OTPs
        for(int i = 0; i < otps.length; i++){
            otps[i] = generateOTP();
        }
        
        //Display generated OTPs
        System.out.print("Generated OTPs: ");
        for(int otp : otps){
            System.out.print(otp + " ");
        }
        System.out.println();
        
        //Check uniqueness
        boolean unique = areOTPsUnique(otps);
        
        if(unique){
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("OTPs are not unique.");
        }
    }
    
    //Method to generate a 6-digit OTP
    public static int generateOTP(){
        //Generate random number between 100000 and 999999
        return (int)(Math.random() * 900000) + 100000;
    }
    
    //Method to check uniqueness of OTPs
    public static boolean areOTPsUnique(int[] otps){
        Set<Integer> set = new HashSet<>();
        for(int otp : otps){
            if(!set.add(otp)){ // if already exists, not unique
                return false;
            }
        }
        return true;
    }
}
