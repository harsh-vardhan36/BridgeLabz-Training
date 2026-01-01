package com.inheritance.vehicleandtransport;

public class VehicleMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle vl = new Vehicle(300, "Petrol");
		Car cr = new Car(150,"Diesel");
		MotorCycle mc = new MotorCycle(120,"Petrol");
		
		vl.displayinfo();
		cr.displayinfo();
		mc.displayinfo();
	}
}
