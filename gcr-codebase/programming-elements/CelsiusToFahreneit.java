import java.util.Scanner;
class CelsiusToFahrenheit
{
public static void main(String [] args)
{

//user Input.
  Scanner in = new Scanner(System.in);
  int Celsius = in.nextInt();
  int Fahrenheit = (Celsius * 9/5)+ 32;
  System.out.println(Fahrenheit);
}
}