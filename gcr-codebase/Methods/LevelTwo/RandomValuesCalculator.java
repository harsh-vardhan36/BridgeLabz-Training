//Program to generate five 4-digit random values and find their average, min, and max.
import java.util.Scanner;

public class RandomValuesCalculator{
    public static void main(String [] args){
    
        Scanner in = new Scanner(System.in);
        
        //Creating object of RandomValuesCalculator
        RandomValuesCalculator RVC = new RandomValuesCalculator();
        
        //Generate 5 random 4-digit numbers
        int[] randomNumbers = RVC.generate4DigitRandomArray(5);
        
        //Display generated numbers
        System.out.print("Generated 4-digit random numbers: ");
        for(int num : randomNumbers){
            System.out.print(num + " ");
        }
        System.out.println();
        
        //Find average, min, and max
        double[] results = RVC.findAverageMinMax(randomNumbers);
        
        //Display results
        System.out.println("Average value: " + results[0]);
        System.out.println("Minimum value: " + results[1]);
        System.out.println("Maximum value: " + results[2]);
    }
    
    //Method to generate array of 4-digit random numbers
    public int[] generate4DigitRandomArray(int size){
        int[] numbers = new int[size];
        for(int i = 0; i < size; i++){
            //Generate random 4-digit number between 1000 and 9999
            numbers[i] = (int)(Math.random() * 9000) + 1000;
        }
        return numbers;
    }
    
    //Method to find average, min, and max of an array
    public double[] findAverageMinMax(int[] numbers){
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        
        for(int num : numbers){
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        double average = (double)sum / numbers.length;
        
        return new double[]{average, min, max};
    }
}
