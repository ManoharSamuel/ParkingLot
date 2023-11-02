package repository;

import exception.GateNotFoundException;
import models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    private Map<Integer, Gate> gateMap;

    public GateRepository() {
        this.gateMap = new HashMap<>();
    }

    public Gate getGate(int gateId) {
        if (gateMap.containsKey(gateId)) {
            return gateMap.get(gateId);
        } else {
            throw new GateNotFoundException("Gate with id "+gateId+" not found.");
        }
    }

    public void setGate(Gate gate) {
        gateMap.put(gate.getId(), gate);
        System.out.println("Gate with id "+gate.getId()+" has been added successfully.");
    }
}
