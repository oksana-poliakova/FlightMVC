package servlet;

import dto.FlightDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.FlightService;
import util.JspHelper;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toMap;

/**
 * @author oksanapoliakova on 20.07.2023
 * @projectName FlightMVC
 */

@WebServlet("/content")
public class ContentServlet extends HttpServlet {
    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Fetching the list of all flights from the FlightService
        List<FlightDto> flightDtos = flightService.findAll();
        // Setting the list of flights as an attribute "flights" for the request
        req.setAttribute("flights", flightDtos);
        // Creating a Map where the key is the ID of the flight, and the value is the description of the flight,
        // then setting this Map as an attribute "flightsMap" for the session
        req.getSession().setAttribute("flightsMap", flightDtos.stream()
                .collect(toMap(FlightDto::getId, FlightDto::getDescription)));

        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req, resp);
    }
}
