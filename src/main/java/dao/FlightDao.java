package dao;

import entity.Flight;
import entity.FlightStatus;
import util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 * @author Oksana Poliakova on 18.07.2023
 * @projectName FlightMVC
 */

/** Class that implements the Dao interface for working with objects
 * It provides access to Flight data and provides basic CRUD operations
 * to manage Flight objects in the data source.
 */
public class FlightDao implements Dao<Long, Flight> {
    private static final FlightDao INSTANCE = new FlightDao();

    private static final String FIND_ALL = """
            SELECT *
            FROM flight
    """;

    private FlightDao() {
    }

    @Override
    public List<Flight> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Flight> flights = new ArrayList<>();
            while (resultSet.next()) {
                flights.add(buildFlight(resultSet));
            }

            return flights;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Flight entity) {

    }

    @Override
    public Flight save(Flight entity) {
        return null;
    }

    public static FlightDao getInstance() {
        return INSTANCE;
    }

    // Extracting column values from the ResultSet and creating a new Flight object
    private Flight buildFlight(ResultSet resultSet) throws SQLException {
        return new Flight(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("flight_no", String.class),
                resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("departure_airport_code", String.class),
                resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("arrival_airport_code", String.class),
                resultSet.getObject("aircraft_id", Integer.class),
                FlightStatus.valueOf(resultSet.getObject("status", String.class))
        );
    }
}
