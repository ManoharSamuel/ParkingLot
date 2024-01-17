package services;

import exceptions.InvalidGateException;
import exceptions.InvalidParkingLotException;
import exceptions.NoParkingSpotAvailableException;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import strategies.parkingspotassignmentstrategy.ParkingSpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private final GateRepository gateRepository;
    private final ParkingLotRepository parkingLotRepository;
    private final TicketRepository ticketRepository;
    private final ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy;
    private final VehicleRepository vehicleRepository;

    public TicketService(GateRepository gateRepository, ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository, ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy,
                         VehicleRepository vehicleRepository) {
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingSpotAssignmentStrategy = parkingSpotAssignmentStrategy;
    }

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, long gateId, long parkingLotId){
        Optional<Gate> gateOptional = gateRepository.getGateById(gateId);
        if (gateOptional.isEmpty()) {
            throw new InvalidGateException("No gate found with the given gate id.");
        }
        Gate gate = gateOptional.get();
        Operator currentOperator = gate.getCurrentOperator();

        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotById(parkingLotId);
        if (parkingLotOptional.isEmpty()) {
            throw new InvalidParkingLotException("No Parking Lot found with the given parking lot id.");
        }
        ParkingLot parkingLot = parkingLotOptional.get();
        Vehicle vehicle;
        Optional<Vehicle> vehicleOptional = vehicleRepository.getVehicleByNumber(vehicleNumber);
        if (vehicleOptional.isPresent()) {
            vehicle = vehicleOptional.get();
        } else {
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicleRepository.save(vehicle);
        }

        Optional<ParkingSpot> parkingSpotOptional = parkingSpotAssignmentStrategy.getParkingSpot(vehicleType, parkingLot, gate);

        if (parkingSpotOptional.isEmpty()) {
            throw new NoParkingSpotAvailableException("No Parking Spot available.");
        }

        ParkingSpot parkingSpot = parkingSpotOptional.get();

        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setOperator(currentOperator);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());
        ticket.setParkingSpot(parkingSpot);

        return ticketRepository.save(ticket);

    }
}
