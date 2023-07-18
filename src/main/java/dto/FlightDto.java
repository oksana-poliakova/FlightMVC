package dto;

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
public class FlightDto {
    private final Long id;
    private final String description;

    public FlightDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    // Compares the flight identifiers and descriptions
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDto flightDto = (FlightDto) o;
        return Objects.equals(id, flightDto.id) &&
               Objects.equals(description, flightDto.description);
    }

    // Generates a hash code
    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "FlightDto{" +
               "id=" + id +
               ", description='" + description + '\'' +
               '}';
    }
}
