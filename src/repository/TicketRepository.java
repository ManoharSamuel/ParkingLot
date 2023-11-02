package repository;

import exception.TicketNotFoundException;
import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Integer, Ticket> ticketMap;

    public TicketRepository() {
        this.ticketMap = new HashMap<>();
    }

    public void setTicket(Ticket ticket) {
        ticketMap.put(ticket.getId(), ticket);
        System.out.println("Ticket with id "+ticket.getId()+" has been added successfully.");
    }

    public Ticket getTicket(int ticketId) {
        if (ticketMap.containsKey(ticketId)) {
            return ticketMap.get(ticketId);
        } else {
            throw new TicketNotFoundException("Ticket with id "+ticketId+" is not found.");
        }
    }
}
