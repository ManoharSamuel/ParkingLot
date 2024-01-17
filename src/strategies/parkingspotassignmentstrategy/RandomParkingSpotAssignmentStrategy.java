package strategies.parkingspotassignmentstrategy;

import models.*;

import java.util.Optional;

public class RandomParkingSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy{
    @Override
    public Optional<ParkingSpot> getParkingSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) {
        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                if (parkingSpot.getSpotStatus().equals(SpotStatus.AVAILABLE) &&
                    parkingSpot.getSupportedVehicles().contains(vehicleType)) {
                    parkingSpot.setSpotStatus(SpotStatus.UNAVAILABLE);
                    return Optional.of(parkingSpot);
                }
            }
        }
        return Optional.empty();
    }
}
