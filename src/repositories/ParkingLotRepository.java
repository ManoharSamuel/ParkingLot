package repositories;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import models.ParkingLot;

public class ParkingLotRepository {
    private final Map<Long, ParkingLot> parkingLotMap;
    private long currentId;

    public ParkingLotRepository() {
        this.parkingLotMap = new TreeMap<>();
        currentId = 0L;
    }

    public ParkingLot save(ParkingLot parkingLot) {
        currentId++;
        parkingLot.setId(currentId);
        parkingLotMap.put(currentId, parkingLot);
        return parkingLot;
    }

    public Optional<ParkingLot> getParkingLotById(long parkingLotId) {
        if (parkingLotMap.containsKey(parkingLotId)) {
            return Optional.of(parkingLotMap.get(parkingLotId));
        } else {
            return Optional.empty();
        }
    }
}
