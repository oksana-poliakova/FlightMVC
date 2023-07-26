<%--
  Created by IntelliJ IDEA.
  User: oksanapoliakova
  Date: 25.07.2023
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Form</title>
</head>
<body>

<img src="https://img.freepik.com/free-photo/puppy-that-is-walking-snow_1340-37228.jpg" alt="Puppy" width="550" height="350">
<h3>Registration form</h3>
<form action="/registration" method="post" enctype="multipart/form-data">
    <label for="name">Name:
        <input type="text" name="name" id="name" required>
    </label>
    <br>
    <label for="birthday">Birthday:
        <input type="date" name="birthday" id="birthday">
    </label>
    <br>
    <label for="emailId">Email:
        <input type="text" name="email" id="emailId" required>
    </label>
    <br>
    <label for="passwordId">Password:
        <input type="password" name="password" id="passwordId" required>
    </label>
    <br>
    <label>
        <select name="role" id="role">
            <option value="USER">USER</option>
            <option value="ADMIN">ADMIN</option>
        </select>
    </label>
    <br>
    <label>
        <input type="radio" name="gender" value="MALE"> Male
        <input type="radio" name="gender" value="FEMALE"> Female
    </label>
    <br>
    <label for="imageId">Image
        <input type="file" name="image" id="imageId">
    </label>
    <br>
    <button type="submit">Send</button>
</form>
</body>
</html>
