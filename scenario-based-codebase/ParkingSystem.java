import java.util.Scanner;
class ParkingSystem{
    static Scanner input = new Scanner(System.in);
    static int occupied = 0;
    static final int seatCapacity = 2;
    static String [] cars = new String[seatCapacity];
    
    //Park Car, Vehicle...
    public static void parkvehicle(){
        if(occupied==seatCapacity){
            System.out.println("Sorry, No seat available!");
        }
        else {
            System.out.println("seat available..");
            System.out.print("Please Enter your vehicle number:\n>");
            String vehicleNum  = input.next();
            cars[occupied]  = vehicleNum;
            occupied++;
            System.out.println("Your car is parked on platform: "+occupied);
        }
    }
    
    //Exit your parked vehicle..
    public static void exitVehicle(){
        
        if(occupied == 0) {
            System.out.println("Are you sure you parked your vehicle Here..");
            System.out.println(" ");
            System.out.println("parked vehicle -> "+occupied );
        }
        else{
            System.out.print("Please Enter your vehicle platform Number:\n> ");
            int platform = input.nextInt();
            if(platform <= 0 || platform > occupied){
              System.out.println("Invalid platform number.");
                 return;
             }

            else{
                System.out.println("Please verify your vehicle No. : "+cars[platform-1]);
                String exitedCar = cars[platform-1];
                //Removing vehicleNum from the array cars.
                for(int i = platform - 1; i < occupied - 1; i++){
                 cars[i] = cars[i + 1];   // shift left
                }
                System.out.println(exitedCar+" exited successfully!");
                cars[occupied - 1] = null; // clear last slot
                occupied--;
                

            }
        }
    }
    public static void showOccupancy(){
        System.out.println("Total Capacity: "+ seatCapacity);
        System.out.println("Occupied platform: "+ occupied);
        System.out.println("Available platform: "+(seatCapacity - occupied));
    }
    
    public static void main(String [] args){
       
        System.out.println("Welcome to Parking Lot.");
        System.out.println(" ");
        boolean parkingON = true;
        while(parkingON){
            System.out.println("-------------------------------");
            System.out.println("Please choose your desired Menu.");
            System.out.println("1. Park vehicle. \n2. Exit Vehicle.\n3. Show Occupancy.\n4. Exit Parking.");
            System.out.print("\n Please specify your desired option in numbers: '1' '2' '3' '4' \n>");
            int userChoice = input.nextInt();
            switch(userChoice){
                case 1:
                    parkvehicle();
                     break;
                case 2:
                    exitVehicle();
                     break;
                case 3:
                    showOccupancy();
                     break;
                case 4:
                    parkingON = false;
                    break;
            }
            
        }
        System.out.println("Thanks for using Our Services!\n--Happy Journey--");
        
    }
}