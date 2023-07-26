<%--
  Created by IntelliJ IDEA.
  User: oksanapoliakova
  Date: 26.07.2023
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login" method="post">
    <label for="email">Email:
        <input type="text" name="email" id="email" value="email" required>
    </label>
    <br>
    <label for="password">Password:
        <input type="password" name="password" id="password" required>
    </label>
    <br>
    <button type="submit">Login</button>
    <a href="/registration">
        <button type="button">Register</button>
    </a>
    <%-- Checking if the 'error' parameter exists in the request parameters --%>
    <% if (request.getParameter("error") != null) { %>
    <div style="color: red">
        <span>Email or password is not correct</span>
    </div>
    <% } %>
</form>
</body>
</html>
