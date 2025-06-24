package lld.parkingLot.fee;

import java.util.Map;

import lld.parkingLot.Ticket;
import lld.parkingLot.vehicle.VehicleType;

public class VehicleBasedFeeStrategy implements FeeStrategy {
    private final Map<VehicleType,Double> hourlyRates = Map.of(VehicleType.Car, 20.0, VehicleType.Bike, 10.0, VehicleType.Truck, 30.0);

    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTime() - ticket.getEntryTime();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * hourlyRates.get(ticket.getVehicle().getVehicleType());
    }
}
