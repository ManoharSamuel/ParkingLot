package repository;

import exception.ParkingFloorNotFoundException;
import models.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    private Map<Integer, ParkingFloor> parkingFloorMap;

    public ParkingFloorRepository() {
        this.parkingFloorMap = new HashMap<>();
    }

    public ParkingFloor getParkingFloor(int parkingFloorId) {
        if (parkingFloorMap.containsKey(parkingFloorId)) {
            return parkingFloorMap.get(parkingFloorId);
        } else {
            throw new ParkingFloorNotFoundException("Parking Floor with id "+parkingFloorId+" not found.");
        }
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        parkingFloorMap.put(parkingFloor.getId(), parkingFloor);
        System.out.println("Parking Floor with id "+parkingFloor.getId()+" has been added successfully");
    }
}
