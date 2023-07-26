package filter;

import dto.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.UrlPath;

import java.io.IOException;
import java.util.Set;
import java.util.logging.LogRecord;

import static util.UrlPath.*;

/**
 * @author oksanapoliakova on 26.07.2023
 * @projectName FlightMVC
 */

@WebFilter("/*")
public class AuthorizationFilter implements Filter {
    private static final Set<String> PUBLIC_PATH = Set.of(LOGIN, REGISTRATION, IMAGES);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var uri = ((HttpServletRequest) servletRequest).getRequestURI();
        if (isPublicPath(uri) || isUserLoggedIn(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            reject(servletRequest, servletResponse);
        }
    }

    // Check if a user is logged in by checking the "user" attribute in the session
    private boolean isUserLoggedIn(ServletRequest servletRequest) {
        var user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return user != null;
    }

    // Check if the given URI corresponds to a public path defined in PUBLIC_PATH set
    private boolean isPublicPath(String uri) {
        return PUBLIC_PATH.stream().anyMatch(uri::startsWith);
    }

    // Redirect the user to the login page or the previous page if available
    private void reject(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        var prevPage = ((HttpServletRequest) servletRequest).getHeader("referer");
        ((HttpServletResponse) servletResponse).sendRedirect(prevPage != null ? prevPage : LOGIN);
    }
}
