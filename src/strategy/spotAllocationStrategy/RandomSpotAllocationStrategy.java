package strategy.spotAllocationStrategy;

import exception.ParkingSpotNotFoundException;
import models.*;
import repository.ParkingLotRepository;

public class RandomSpotAllocationStrategy implements SpotAllocationStrategy{
    private ParkingLotRepository parkingLotRepository;

    public RandomSpotAllocationStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingSpot getSpot(VehicleType vehicleType, Gate gate) {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotFromGate(gate);

        ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(gate.getFloorNumber()-1);

        for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
            if (parkingSpot.getSupportedVehicleType().equals(vehicleType)
                    && parkingSpot.getStatus().equals(Status.AVAILABLE)) {
                return parkingSpot;
            }
        }

        for(ParkingFloor parkingFloorOne : parkingLot.getParkingFloors()) {
            for(ParkingSpot parkingSpot : parkingFloorOne.getParkingSpots()) {
                if (parkingSpot.getSupportedVehicleType().equals(vehicleType)
                        && parkingSpot.getStatus().equals(Status.AVAILABLE)) {
                    return parkingSpot;
                }
            }
        }

        throw new ParkingSpotNotFoundException("Parking Spot is not available for the "+vehicleType.name()+" vehicle type.");
    }
}
