<%--
  Created by IntelliJ IDEA.
  User: oksanapoliakova
  Date: 26.07.2023
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>

<%
    Locale locale = new Locale("uk", "UA");
    ResourceBundle bundle = ResourceBundle.getBundle("translations", locale);
%>

<html>
<head>
    <title><%= bundle.getString("login.title") %></title>
</head>
<body>
<form action="/login" method="post">
    <label for="email"><%= bundle.getString("login.email") %>
        <input type="text" name="email" id="email" value="email" required>
    </label>
    <br>
    <label for="password"><%= bundle.getString("login.password") %>
        <input type="password" name="password" id="password" required>
    </label>
    <br>
    <button type="submit"><%= bundle.getString("login.submit") %></button>
    <a href="/registration">
        <button type="button"><%= bundle.getString("login.register") %></button>
    </a>
    <% if (request.getParameter("error") != null) { %>
    <div style="color: red">
        <span><%= bundle.getString("login.error") %></span>
    </div>
    <% } %>
</form>
</body>
</html>
