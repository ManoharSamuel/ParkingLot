package repositories;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import models.Ticket;

public class TicketRepository {
    private final Map<Long, Ticket> ticketMap;
    private long currentId;

    public TicketRepository() {
        this.ticketMap = new TreeMap<>();
        currentId = 0L;
    }

    public Ticket save(Ticket ticket) {
        currentId++;
        ticket.setId(currentId);
        ticketMap.put(currentId, ticket);
        return ticket;
    }

    public Optional<Ticket> getTicketById(long ticketId) {
        if (ticketMap.containsKey(ticketId)) {
            return Optional.of(ticketMap.get(ticketId));
        } else {
            return Optional.empty();
        }
    }
}
