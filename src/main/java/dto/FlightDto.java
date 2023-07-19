package dto;

import lombok.*;

import java.util.Objects;

/**
 * @author Oksana Poliakova on 18.07.2023
 * @projectName FlightMVC
 */

/**
 * The FlightDto class is a simple data transfer object (DTO) that represents a flight.
 * It encapsulates the flight's identifier and description and provides getter methods to access these values.
 * Additionally, it overrides the equals, hashCode, and toString methods for proper object comparison and string representation.
 * The class serves as a container for transporting flight data between different layers or components of an application.
 */

@Value
@Builder

public class FlightDto {
    private final Long id;
    private final String description;
}
