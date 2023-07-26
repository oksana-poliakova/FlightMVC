package filter;

import jakarta.servlet.*;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author oksanapoliakova on 26.07.2023
 * @projectName FlightMVC
 */
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getParameterMap().forEach((k, v) -> System.out.println(k + ": " + Arrays.toString(v)));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
