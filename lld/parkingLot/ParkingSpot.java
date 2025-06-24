package lld.parkingLot;

import lld.parkingLot.vehicle.Vehicle;
import lld.parkingLot.vehicle.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle vehicle;
    private boolean empty;
    public ParkingSpot(int spotNumber, VehicleType vehicleType){

        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.empty = true;

    }
    public synchronized boolean isAvailable(){
        return empty;
    }
    public synchronized boolean park(Vehicle vehicle){
        if (!empty || vehicle.getVehicleType()!=vehicleType) {
            return false;
        }
        this.vehicle = vehicle;
        empty = false;
        return true;
    }
    public synchronized void unpark(){
        this.vehicle = null;
        empty = true;
    }
    public int getSpotNumber(){
        return spotNumber;
    }
    public VehicleType getVehicleType(){
        return vehicleType;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    
}
