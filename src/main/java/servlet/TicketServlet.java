package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.TicketService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Oksana Poliakova on 18.07.2023
 * @projectName FlightMVC
 */

/**
 * This servlet handles HTTP GET requests for the "/tickets" path.
 * It retrieves the "flightId" parameter from the request and uses the TicketService to fetch a list of purchased tickets associated with that flight.
 * The servlet then displays the list of seat numbers as an unordered list in the HTTP response.
 * Servlet provides functionality to view purchased tickets for a specific flight.
 */

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {
    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var printWriter = resp.getWriter()) {
            printWriter.write("<h1>Purchased tickets:</h1>");
            printWriter.write("<ul>");
            // Iterating over each TicketDto object and printing each seat number as a list item
            ticketService.findAllByFlightId(1L).forEach(ticketDto -> printWriter.write("""
                    <li>
                        %s
                    </li>
                    """.formatted(ticketDto.getSeatNo())));
            printWriter.write("</ul>");
        }
    }
}
