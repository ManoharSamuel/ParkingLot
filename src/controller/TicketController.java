package controller;

import dto.ResponseStatus;
import dto.TicketIssueRequestDTO;
import dto.TicketIssueResponseDTO;
import exception.InvalidTicketIssueRequestException;
import models.Ticket;
import service.TicketService;

public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketIssueResponseDTO getTicket(TicketIssueRequestDTO ticketIssueRequestDTO) {
        TicketIssueResponseDTO ticketIssueResponseDTO = new TicketIssueResponseDTO();
        try {
            if (ticketIssueRequestDTO.getGateId() == 0 ||
                ticketIssueRequestDTO.getVehicleType() == null ||
                ticketIssueRequestDTO.getVehicleColor() == null ||
                ticketIssueRequestDTO.getVehicleMake() == null ||
                ticketIssueRequestDTO.getVehicleNumber() == null) {
                throw new InvalidTicketIssueRequestException("Ticket Issue Request data is invalid/incomplete.");
            }
            Ticket ticket = ticketService.getTicket(ticketIssueRequestDTO.getVehicleType(),
                                                    ticketIssueRequestDTO.getVehicleColor(),
                                                    ticketIssueRequestDTO.getVehicleMake(),
                                                    ticketIssueRequestDTO.getVehicleNumber(),
                                                    ticketIssueRequestDTO.getGateId());
            ticketIssueResponseDTO.setTicket(ticket);
            ticketIssueResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);

        } catch (Exception e) {
            ticketIssueResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            ticketIssueResponseDTO.setFailureMessage("Ticket creation failed because the request data is incomplete/invalid");
        }
        return ticketIssueResponseDTO;
    }
}
