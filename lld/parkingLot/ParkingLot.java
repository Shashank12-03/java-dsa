package lld.parkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import lld.parkingLot.fee.FeeStrategy;
import lld.parkingLot.fee.FlatRateFeeStrategy;
import lld.parkingLot.vehicle.Vehicle;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Floor> floors;
    private final Map<String, Ticket> activeTickets =  new ConcurrentHashMap<>();
    private FeeStrategy feeStrategy;
    private ParkingLot(){
        floors = new ArrayList<>();
        feeStrategy = new FlatRateFeeStrategy();
    }
    public static synchronized ParkingLot getInstance(){
        if(instance==null){
            instance = new ParkingLot();
        }
        return instance;
    }
    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public void setFeeStrategy (FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) throws Exception {
        for (Floor floor : floors) {
            Optional<ParkingSpot> spotOpt = floor.getAvailableSpot(vehicle.getVehicleType());
            if (spotOpt.isPresent()) {
                ParkingSpot spot = spotOpt.get();
                if (spot.park(vehicle)) {
                    String ticketId = UUID.randomUUID().toString();
                    Ticket ticket = new Ticket(vehicle, ticketId, spot);
                    activeTickets.put(ticketId, ticket);
                    return ticket;
                }
            }
        }
        throw new Exception("No available spot for " + vehicle.getVehicleType());
    }

    public synchronized double unparkVehicle(String ticketId) throws Exception {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) throw new Exception("Invalid ticket");

        ParkingSpot spot = ticket.getSpot();
        spot.unpark();

        ticket.setExitTime();
        return feeStrategy.calculateFee(ticket);
    }

    public List<Floor> getParkingFloors() {
        return floors;
    }
}

// parking has multiple floors so list of floors
// each floor has multiple parkings for each type of vehicle 
// so maybe a map which stores vehicle type and number of parking slots
// so basically each floor is list<map<VehicleType,Integer>> 
// when vehicle is parked for each floor maintain a map which stores parking id and the numberplate/id of vehicle and decrease a parking slot
// unpark is just free up the parking id, increase the slot
// fee calculation totally different work, we can preset fees per hour and take input for hrs and then just multiply 



// Multiple Floors: The parking lot can have multiple floors.
// Parking Spots: Each floor has multiple parking spots of different types (e.g., car, bike, truck).
// Vehicle Types: Support for different vehicle types (see vehicletype/).
// Ticketing: Generate a ticket when a vehicle is parked.
// Unparking: Allow vehicles to unpark and calculate the parking fee.
// Fee Calculation: Support for different fee strategies (see fee/).
// Spot Allocation: Allocate the nearest available spot of the correct type.
// Extensibility: Easy to add new vehicle types, spot types, or fee strategies.