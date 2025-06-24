package lld.parkingLot;

import java.util.List;
import java.util.Optional;

import lld.parkingLot.vehicle.VehicleType;

public class Floor {
    // floor has parking spot 
    // floor number
    private int floorNumber;
    private  List<ParkingSpot> parkingSpots;

    public Floor(int floorNumber,List<ParkingSpot> parkingSpots){
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }
    public int getFloorNumber(){
        return floorNumber;
    }
    public List<ParkingSpot> getParkingSpots(){
        return parkingSpots;
    }

    public synchronized Optional<ParkingSpot> getAvailableSpot(VehicleType type){
        return parkingSpots.stream().filter(spot->spot.isAvailable() && spot.getVehicleType()==type).findFirst();
    }
    public synchronized List<Integer> getAvailableSpots(VehicleType type){
        return parkingSpots.stream().filter(spot->spot.isAvailable() && spot.getVehicleType()==type).map(ParkingSpot::getSpotNumber).toList();
    }
}
