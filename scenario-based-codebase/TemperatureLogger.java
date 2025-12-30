import java.util.Scanner;

public class TemperatureLogger{
    
    public static void findTemperature(double [] temperatures){
        int day = 0;
        double sum = 0;
        double maximumTemp = temperatures[0];
        for(int i = 0; i < temperatures.length; i++){
            sum += temperatures[i];
            if(maximumTemp<temperatures[i]) day = i; maximumTemp = temperatures[i];
        }
        double average = (sum/temperatures.length);
        System.out.println("The Maximum temperature is: "+maximumTemp +" on day: "+(day+1));
        System.out.println("The average temperature is: "+average);
    }
    
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        double [] temperatures = new double[7];
        System.out.println("Please Enter the temperature of 7 day One by One.");
        for(int i = 0; i < temperatures.length; i++){
            System.out.print("Enter Day "+(i+1)+" temperature:\n>");
            double temp = input.nextDouble();
            temperatures[i] = temp;
        }
        
        findTemperature(temperatures);
    }
}