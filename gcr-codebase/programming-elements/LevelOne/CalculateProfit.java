public class CalculateProfit{
	public static void main(String [] args){
	
	//Given cost price and Selling price
	 double Cost_price = 129;
	 double Selling_price = 191;
	 
	//Formula: profit = Selling_price - Cost_price
	 double profit = Selling_price - Cost_price;
	 
	//Formula: profit_percent = profit/cost_price*100
	 double profit_percent = ((profit/Cost_price)*100);
	 
	 //Printing the values
	 System.out.println("The Cost price is INR "+Cost_price +" and Selling price is INR "+Selling_price);
	 System.out.println("The profit is INR "+profit +" and the Profit Percentage is "+profit_percent);
	
	 
	 
	 
	}
}