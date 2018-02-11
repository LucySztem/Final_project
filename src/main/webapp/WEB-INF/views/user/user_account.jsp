<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 03.02.18
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>My account</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-striped">
    <tr>
        <td> Parties you have hosted</td>
        <td> Date</td>
        <td> Number of people</td>
        <td>More options</td>
    </tr>
    <c:forEach items="${list}" var="event">
        <tr>
            <td>${event.description}</td>
            <td>${event.date}</td>
            <td>${event.people}</td>
            <td><a href="/event/${event.id}">Go to the event page</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
