package repositories;

import models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    private final Map<Long, Gate> gateMap;
    private long currentId;

    public GateRepository() {
        this.gateMap = new TreeMap<>();
        this.currentId = 0L;

    }

    public Gate save(Gate gate) {
        currentId++;
        gate.setId(currentId);
        gateMap.put(currentId, gate);
        return gate;
    }

    public Optional<Gate> getGateById(long id) {
        if (gateMap.containsKey(id)) {
            return Optional.of(gateMap.get(id));
        } else {
            return Optional.empty();
        }
    }
}
