package service;

import dao.TicketDao;
import dto.FlightDto;
import dto.TicketDto;

import java.util.List;
import static java.util.stream.Collectors.toList;


/**
 * @author Oksana Poliakova on 18.07.2023
 * @projectName FlightMVC
 */
public class TicketService {
    // Singleton instance of TicketService
    private static final TicketService INSTANCE = new TicketService();

    // TicketDao instance for data access
    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {
    }

    public List<TicketDto> findAllByFlightId(Long flightId) {
        // Retrieve list of tickets by flightId from ticketDao
        return ticketDao.findAllByFlightId(flightId).stream()
                // Map each Ticket object to TicketDto object
                .map(ticket -> TicketDto.builder()
                        .id(ticket.getId())
                        .flightId(ticket.getFlightId())
                        .seatNo(ticket.getSeatNo())
                        .build()
                )
                // Collect TicketDto objects into a list
                .collect(toList());
    }

    // Return the singleton instance of TicketService
    public static TicketService getInstance() {
        return INSTANCE;
    }
}
