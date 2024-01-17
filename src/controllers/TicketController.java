package controllers;

import dtos.ResponseStatus;
import dtos.TicketRequestDTO;
import dtos.TicketResponseDTO;
import models.Ticket;
import models.VehicleType;
import services.TicketService;

public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketResponseDTO generateTicket(TicketRequestDTO ticketRequestDTO) {
        String vehicleNumber = ticketRequestDTO.getVehicleNumber();
        VehicleType vehicleType = ticketRequestDTO.getVehicleType();
        long gateId = ticketRequestDTO.getGateId();
        long parkingLotId = ticketRequestDTO.getParkingLotId();

        Ticket ticket = ticketService.generateTicket(vehicleNumber, vehicleType, gateId, parkingLotId);

        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
        ticketResponseDTO.setTicketId(ticket.getId());
        ticketResponseDTO.setMessage("Ticket is created successfully");
        ticketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        ticketResponseDTO.setOperatorName(ticket.getOperator().getName());
        return ticketResponseDTO;
    }
}
