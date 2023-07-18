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

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {
    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var flightId = Long.valueOf(req.getParameter("flightId"));

        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (var printWriter = resp.getWriter()) {
            printWriter.write("<h1>Purchased tickets:</h1>");
            printWriter.write("<ul>");
            ticketService.findAllByFlightId(flightId).forEach(ticketDto -> printWriter.write("""
                    <li>
                        %s
                    </li>
                    """.formatted(ticketDto.getSeatNo())));
            printWriter.write("</ul>");
        }
    }
}
