package lld.parkingLot.vehicle;

public class Vehicle {
    protected String license;
    protected VehicleType type;
    public Vehicle(String license, VehicleType type) {
        this.license = license;
        this.type = type;
    }

    public String getLicense(){
        return license;
    }
    public VehicleType getVehicleType(){
        return type;
    }
}
