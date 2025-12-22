///Program to find the shortest, tallest, and mean height of players in a football team.
import java.util.*;

public class FootballTeamHeights{
    public static void main(String [] args){
        
        //Array to store heights of 11 players
        int[] heights = new int[11];
        
        //Generate random heights between 150 and 250 cm
        for(int i = 0; i < heights.length; i++){
            heights[i] = (int)(Math.random() * 101) + 150; // range 150–250
        }
        
        //Display generated heights
        System.out.print("Heights of players (in cm): ");
        for(int h : heights){
            System.out.print(h + " ");
        }
        System.out.println();
        
        //Calculations
        int sum = findSum(heights);
        double mean = findMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);
        
        //Display results
        System.out.println("Sum of heights: " + sum + " cm");
        System.out.println("Mean height: " + mean + " cm");
        System.out.println("Shortest height: " + shortest + " cm");
        System.out.println("Tallest height: " + tallest + " cm");
    }
    
    //Method to find sum of all elements
    public static int findSum(int[] heights){
        int sum = 0;
        for(int h : heights){
            sum += h;
        }
        return sum;
    }
    
    //Method to find mean height
    public static double findMean(int[] heights){
        int sum = findSum(heights);
        return (double)sum / heights.length;
    }
    
    //Method to find shortest height
    public static int findShortest(int[] heights){
        int min = heights[0];
        for(int h : heights){
            min = Math.min(min, h);
        }
        return min;
    }
    
    //Method to find tallest height
    public static int findTallest(int[] heights){
        int max = heights[0];
        for(int h : heights){
            max = Math.max(max, h);
        }
        return max;
    }
}
