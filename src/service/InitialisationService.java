package service;

import models.*;
import repository.*;

import java.util.ArrayList;
import java.util.List;

public class InitialisationService {
    private GateRepository gateRepository;
    private OperatorRepository operatorRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingLotRepository parkingLotRepository;

    public InitialisationService() {
        this.gateRepository = new GateRepository();
        this.operatorRepository = new OperatorRepository();
        this.parkingSpotRepository = new ParkingSpotRepository();
        this.parkingFloorRepository = new ParkingFloorRepository();
        this.parkingLotRepository = new ParkingLotRepository();
    }

    public ParkingLot initialise() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setCapacity(100);
        parkingLot.setAddress("Road R, Citi C, State S");
        parkingLot.setStatus(Status.ACTIVE);

        Operator operatorOne =new Operator();
        operatorOne.setId(1);
        operatorOne.setEmail("operator1@abc.com");
        operatorOne.setName("operator1");
        operatorOne.setEmpId(10001);
        operatorOne.setPhoneNumber("123-123-1234");

        Operator operatorTwo =new Operator();
        operatorTwo.setId(2);
        operatorTwo.setEmail("operator2@abc.com");
        operatorTwo.setName("operator2");
        operatorTwo.setEmpId(10002);
        operatorTwo.setPhoneNumber("123-123-1235");

        operatorRepository.setOperator(operatorOne);
        operatorRepository.setOperator(operatorTwo);

        Gate entryGate = new Gate();
        entryGate.setId(1);
        entryGate.setStatus(Status.AVAILABLE);
        entryGate.setOperator(operatorOne);
        entryGate.setGateNumber(1);
        entryGate.setFloorNumber(1);
        entryGate.setGateType(GateType.ENTRY);
        entryGate.setParkingLotID(parkingLot.getId());

        Gate exitGate = new Gate();
        exitGate.setId(2);
        exitGate.setStatus(Status.AVAILABLE);
        exitGate.setOperator(operatorTwo);
        exitGate.setGateNumber(2);
        exitGate.setFloorNumber(1);
        exitGate.setGateType(GateType.EXIT);
        exitGate.setParkingLotID(parkingLot.getId());

        gateRepository.setGate(entryGate);
        gateRepository.setGate(exitGate);
        parkingLot.setGates(List.of(entryGate, exitGate));

        List<ParkingFloor> parkingFloors = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(100 + i);
            parkingFloor.setStatus(Status.AVAILABLE);
            parkingFloor.setFloorNumber(i);
            for (int j = 1; j <= 10; j++) {
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setId(i * 100 + 2 * j);
                parkingSpot.setNumber(i * 1000 + j);
                parkingSpot.setStatus(Status.AVAILABLE);
                if (j%2 == 0) {
                    parkingSpot.setSupportedVehicleType(VehicleType.Two_Wheeler);
                } else {
                    parkingSpot.setSupportedVehicleType(VehicleType.Four_Wheeler);
                }
                parkingSpots.add(parkingSpot);
                parkingSpotRepository.setParkingSpot(parkingSpot);
            }
            parkingFloor.setParkingSpots(parkingSpots);
            parkingFloorRepository.setParkingFloor(parkingFloor);
            parkingFloors.add(parkingFloor);
        }

        parkingLot.setParkingFloors(parkingFloors);
        parkingLotRepository.setParkingLot(parkingLot);
        return parkingLot;
    }
}
