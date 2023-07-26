<%@ page import="entity.Flight" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: oksanapoliakova
  Date: 26.07.2023
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>List of flights</h1>
<ul>
    <% for (Flight flight : (List<Flight>) request.getAttribute("flights")) { %>
    <li>
        <a href="<%= request.getContextPath() %>/tickets?flightId=<%= flight.getId() %>">
            <%= flight.getFlightNo() %>
        </a>
    </li>
    <% } %>
</ul>

<form action="<%= request.getContextPath() %>/logout" method="post">
    <button type="submit">Logout</button>
</form>

</body>
</html>
