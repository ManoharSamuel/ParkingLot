package models;

import java.util.List;

public class ParkingSpot extends BaseModel{
    private List<VehicleType> supportedVehicles;
    private int spotNumber;
    private SpotStatus spotStatus;
    private Vehicle vehicle;

    public List<VehicleType> getSupportedVehicles() {
        return supportedVehicles;
    }

    public void setSupportedVehicles(List<VehicleType> supportedVehicles) {
        this.supportedVehicles = supportedVehicles;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public SpotStatus getSpotStatus() {
        return spotStatus;
    }

    public void setSpotStatus(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
