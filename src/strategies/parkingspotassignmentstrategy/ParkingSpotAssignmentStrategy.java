package strategies.parkingspotassignmentstrategy;


import models.Gate;
import models.ParkingLot;
import models.ParkingSpot;
import models.VehicleType;

import java.util.Optional;

public interface ParkingSpotAssignmentStrategy {
    Optional<ParkingSpot> getParkingSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate);
}
