package util;

import lombok.experimental.UtilityClass;

/**
 * @author oksanapoliakova on 20.07.2023
 * @projectName FlightMVC
 */

@UtilityClass
public class JspHelper {
    private static final String JSP_FORMAT = "/WEB-INF/jsp/%s.jsp";

    public static String getPath(String jspName) {
        return String.format(JSP_FORMAT, jspName);
    }
}
