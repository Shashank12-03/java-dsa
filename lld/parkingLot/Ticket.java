package lld.parkingLot;

import java.util.Date;

import lld.parkingLot.vehicle.Vehicle;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final long entryTime;
    private long exitTime;

    public Ticket(Vehicle vehicle, String ticketId, ParkingSpot spot){
        this.vehicle = vehicle;
        this.ticketId = ticketId;
        this.spot = spot;
        this.entryTime = new Date().getTime();
    }
    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime() {
        this.exitTime = new Date().getTime();
    }
}
