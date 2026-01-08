package com.parkease;

class ParkingSlot {

    private String slotId;
    private boolean isOccupied;
    private String vehicleTypeAllowed;

    private String bookingLog; //  internal record

    public ParkingSlot(String slotId, String vehicleTypeAllowed) {
        this.slotId = slotId;
        this.vehicleTypeAllowed = vehicleTypeAllowed;
        this.isOccupied = false;
    }

    public boolean assignSlot(Vehicle vehicle) {
        if (!isOccupied &&
            vehicle.getClass().getSimpleName().equals(vehicleTypeAllowed)) {

            isOccupied = true;
            bookingLog = "Slot " + slotId +
                         " booked for " +
                         vehicle.getVehicleNumber();
            return true;
        }
        return false;
    }

    public void releaseSlot() {
        isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void showLog() {
        System.out.println(bookingLog);
    }
}

