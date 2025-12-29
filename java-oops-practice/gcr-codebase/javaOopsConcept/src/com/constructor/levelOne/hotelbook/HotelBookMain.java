package com.constructor.levelOne.hotelbook;

public class HotelBookMain {
	 public static void main(String[] args) {
		 HotelBooking hb = new HotelBooking();
		 hb.display();
		 
		 HotelBooking hb1 = new HotelBooking("Muskan","ac",3);
		 hb1.display();
		 
		 HotelBooking hb2 = new HotelBooking(hb);
		 hb2.display();
	    }
}
