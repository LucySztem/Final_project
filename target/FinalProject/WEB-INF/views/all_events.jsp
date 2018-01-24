<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 23.01.18
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored = "false" %>
<html>
<head>
    <title>Events</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-striped">
    <thead>
    <tr>
        <td>Id</td>
        <td>What</td>
        <td>Where</td>
        <td>When</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${events}" var ="event">
    <tr class='clickable-row' data-href="/event/${event.id}">
        <td>${event.id}</td>
        <td>${event.description}</td>
        <td>${event.place}</td>
        <td>${event.date}</td>

    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
