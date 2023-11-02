package repository;

import exception.ParkingLotNotFoundException;
import models.Gate;
import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLotMap;

    public ParkingLotRepository() {
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot getParkingLot(int parkingLotId) {
        if (parkingLotMap.containsKey(parkingLotId)) {
            return parkingLotMap.get(parkingLotId);
        } else {
            throw new ParkingLotNotFoundException("Parking Lot with id "+parkingLotId+" not found.");
        }
    }

    public void setParkingLot(ParkingLot parkingLot) {
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        System.out.println("Parking Lot with id "+parkingLot.getId()+" has been added successfully");
    }

    public ParkingLot getParkingLotFromGate(Gate gate) {
        if (parkingLotMap.containsKey(gate.getParkingLotID())) {
            return parkingLotMap.get(gate.getParkingLotID());
        } else {
            throw new ParkingLotNotFoundException("Parking Lot with gate id "+ gate.getParkingLotID()+" not found.");
        }
    }
}
