package service;

import dao.TicketDao;
import dto.TicketDto;

import java.util.List;
import static java.util.stream.Collectors.toList;


/**
 * @author Oksana Poliakova on 18.07.2023
 * @projectName FlightMVC
 */
public class TicketService {
    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {
    }

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(ticket -> new TicketDto(
                        ticket.getId(),
                        ticket.getFlightId(),
                        ticket.getSeatNo()
                ))
                .collect(toList());
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}
