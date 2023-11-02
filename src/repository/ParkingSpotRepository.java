package repository;

import exception.ParkingSpotNotFoundException;
import models.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepository {
    private Map<Integer, ParkingSpot> parkingSpotMap;

    public ParkingSpotRepository() {
        this.parkingSpotMap = new HashMap<>();
    }

    public ParkingSpot getParkingSpot(int parkingSpotId) {
        if (parkingSpotMap.containsKey(parkingSpotId)) {
            return parkingSpotMap.get(parkingSpotId);
        } else {
            throw new ParkingSpotNotFoundException("Parking Spot with id "+parkingSpotId+" not found.");
        }
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotMap.put(parkingSpot.getId(), parkingSpot);
        System.out.println("Parking Spot with id "+parkingSpot.getId()+" has been added successfully");
    }
}
