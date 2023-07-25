package servlet;

import dto.CreateUserDto;
import entity.User;
import exception.ValidationException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import util.JspHelper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author oksanapoliakova on 25.07.2023
 * @projectName FlightMVC
 */

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", List.of("USER", "ADMIN"));
        req.setAttribute("genders", List.of("MALE", "FEMALE"));

        req.getRequestDispatcher(JspHelper.getPath("registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final CreateUserDto userDto = CreateUserDto.builder()
                .name(req.getParameter("name"))
                .birthday(req.getParameter("birthday"))
                .email(req.getParameter("email"))
                .gender(req.getParameter("gender"))
                .password(req.getParameter("password"))
                .role(req.getParameter("role"))
                .build();

        // FIXME: Fix redirect to /login
        try {
            userService.create(userDto);
            resp.sendRedirect("/login");
        } catch (ValidationException | SQLException exception) {
            req.setAttribute("errors", exception.getMessage());
            doGet(req, resp);
        }
    }
}
