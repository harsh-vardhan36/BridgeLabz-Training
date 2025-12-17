public class DividePens{
	public static void main(String [] args){
	//Given there are 14 pens
	  int pens = 14;
	  
	//Given there are 3 students.
	int students = 3;
	
    //Calculating the numbers of pen per students.
	int Distributed_pen = pens/students;
	
	//Calculating the numbers of non-distributed pens.
	int non_distributed = pens%students;
	
	//Displaying the information.
	System.out.println("The Pen Per Student is " + Distributed_pen +" and the remaining pen not distributed is "+ non_distributed);

	}
}