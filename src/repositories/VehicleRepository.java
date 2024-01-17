package repositories;

import models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {
    private final Map<String, Vehicle> vehicleMap;
    private long currentId;

    public VehicleRepository() {
        this.vehicleMap = new TreeMap<>();
        this.currentId = 0L;

    }

    public Vehicle save(Vehicle vehicle) {
        currentId++;
        vehicle.setId(currentId);
        vehicleMap.put(String.valueOf(currentId), vehicle);
        return vehicle;
    }

    public Optional<Vehicle> getVehicleByNumber(String number) {
        if (vehicleMap.containsKey(number)) {
            return Optional.of(vehicleMap.get(number));
        } else {
            return Optional.empty();
        }
    }
}
