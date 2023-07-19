package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;
/**
 * @author Oksana Poliakova on 16.07.2023
 * @projectName FlightMVC
 */

/**
 * The Flight class represents a flight entity. It contains information about a specific flight.
 * The class provides getter and setter methods to access and modify the flight's properties. The getter methods allow retrieving the values of the flight's properties,
 * while the setter methods enable updating the values.
 * The class represents a flight entity and provides methods to access and manipulate its properties, as well as methods for object comparison and string representation.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    private Long id;
    private String flightNo;
    private LocalDateTime departureDate;
    private String departureAirportCode;
    private LocalDateTime arrivalDate;
    private String arrivalAirportCode;
    private Integer aircraftId;
    private FlightStatus status;
}
