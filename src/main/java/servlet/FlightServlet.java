package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.FlightService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Oksana Poliakova on 18.07.2023
 * @projectName FlightMVC
 */

/**
 * The FlightServlet handles HTTP GET requests for the "/flights" path.
 * It retrieves a list of flights using the FlightService, and then generates an HTML response to display the list of flights
 * with clickable links to view ticket details for each flight.
 */

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var printWriter = resp.getWriter()) {
            printWriter.write("<h1>List of flights:</h1>");
            printWriter.write("<ul>");
            // Iterating over all FlightDto objects and printing each one as a list item
            flightService.findAll().forEach(flightDto -> {
                printWriter.write("""
                        <li>
                            <a href="/tickets?flightId=%d">%s</a>
                        </li>
                        """.formatted(flightDto.getId(), flightDto.getDescription()));
            });
            printWriter.write("</ul>");
        }
    }
}