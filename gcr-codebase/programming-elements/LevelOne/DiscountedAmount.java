public class DiscountedAmount{
	public static void main(String [] args){
	//Creating a variable Fee
	 int fee = 125000;
	 
	//creating a variable discountPercent;
	 int discountPercent = 10;
	 
	//compute discount amount
	int discount = (fee *discountPercent)/100;
	 
	//compute final discounted price
	 int finalFee = fee - discount;
    
	//printing final Results
	 System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR "+ finalFee);
	}
}