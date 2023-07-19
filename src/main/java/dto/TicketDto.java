package dto;

import lombok.*;

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

@Value
@Builder

public class TicketDto {
    Long id;
    Long flightId;
    String seatNo;
}
