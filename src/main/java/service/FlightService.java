package service;

import dao.FlightDao;
import dto.FlightDto;

import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * @author Oksana Poliakova on 18.07.2023
 * @projectName FlightMVC
 */

/**
 * The class as a service layer provides flight-related services and acts as an intermediary
 * between the application and the FlightDao data access object.
 *
 * The FlightService class acts as a service layer between the application and the flight-related data access object (FlightDao).
 * It provides methods to retrieve flight information and transform it into a more suitable format (FlightDto) for further use in the application.
 */

public class FlightService {
    private static final FlightService INSTANCE = new FlightService();

    private final FlightDao flightDao = FlightDao.getInstance();

    private FlightService() {
    }

    public List<FlightDto> findAll() {
        return flightDao.findAll().stream()
                .map(flight -> FlightDto.builder()
                        .id(flight.getId())
                        .description(
                                """
                                    %s - %s - %s
                                """.formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatus()))
                        .build()
                )
                .collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
