package entity;

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
public class Flight {
    private Long id;
    private String flightNo;
    private LocalDateTime departureDate;
    private String departureAirportCode;
    private LocalDateTime arrivalDate;
    private String arrivalAirportCode;
    private Integer aircraftId;
    private FlightStatus status;

    public Flight(Long id,
                  String flightNo,
                  LocalDateTime departureDate,
                  String departureAirportCode,
                  LocalDateTime arrivalDate,
                  String arrivalAirportCode,
                  Integer aircraftId,
                  FlightStatus status) {
        this.id = id;
        this.flightNo = flightNo;
        this.departureDate = departureDate;
        this.departureAirportCode = departureAirportCode;
        this.arrivalDate = arrivalDate;
        this.arrivalAirportCode = arrivalAirportCode;
        this.aircraftId = aircraftId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public Integer getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Integer aircraftId) {
        this.aircraftId = aircraftId;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Flight{" +
               "id=" + id +
               ", flightNo='" + flightNo + '\'' +
               ", departureDate=" + departureDate +
               ", departureAirportCode='" + departureAirportCode + '\'' +
               ", arrivalDate=" + arrivalDate +
               ", arrivalAirportCode='" + arrivalAirportCode + '\'' +
               ", aircraftId=" + aircraftId +
               ", status=" + status +
               '}';
    }
}
