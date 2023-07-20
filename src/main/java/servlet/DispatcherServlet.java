package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Oksana Poliakova on 20.07.2023
 * @projectName FlightMVC
 */

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forward: Fully transfers control and data from the current servlet or JSP to another servlet or JSP on the server-side
        // req.getRequestDispatcher("/flights").forward(req, resp);

        // Include: Includes the content of another servlet or JSP within the current servlet on the server-side
        // req.getRequestDispatcher("/flights").include(req, resp);

        // Redirect: Redirects the client to another URL
        resp.sendRedirect("/flights");
    }
}
