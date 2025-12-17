import java.util.Scanner;
class VolumeofCylinder
{
public static void main(String [] args)
{
Scanner in = new Scanner(System.in);
int radius = in.nextInt();
int height = in.nextInt();
int volume = ((22/7)*radius*radius*height);
System.out.println(volume);
}
}