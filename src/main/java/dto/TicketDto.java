package dto;

import java.util.Objects;

/**
 * @author Oksana Poliakova on 18.07.2023
 * @projectName FlightMVC
 */

/**
 * The TicketDto class is a data transfer object (DTO) that represents a ticket.
 * Class serves as a container for transporting ticket data between different layers or components of an application.
 * It allows for convenient access to the ticket's information, such as the ticket identifier, flight identifier,
 * and seat number, and provides methods for object comparison and string representation.
 */

public class TicketDto {
    private final Long id;
    private final Long flightId;
    private final String seatNo;

    public TicketDto(Long id, Long flightId, String seatNo) {
        this.id = id;
        this.flightId = flightId;
        this.seatNo = seatNo;
    }

    public Long getId() {
        return id;
    }

    public Long getFlightId() {
        return flightId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDto ticketDto = (TicketDto) o;
        return Objects.equals(id, ticketDto.id) &&
               Objects.equals(flightId, ticketDto.flightId) &&
               Objects.equals(seatNo, ticketDto.seatNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightId, seatNo);
    }

    @Override
    public String toString() {
        return "TicketDto{" +
               "id=" + id +
               ", flightId=" + flightId +
               ", seatNo='" + seatNo + '\'' +
               '}';
    }
}
