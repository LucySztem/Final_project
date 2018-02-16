<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


<html>
<head>
    <title>Stats</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <%--<link rel="stylesheet" href="/resources/css/show_event.css">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div id="listOfEvents">
    <table class="table table-striped">
        <tr>
            <td>Event description</td>
            <td>Date</td>
            <td>More options</td>
        </tr>
        <c:forEach items="${listOfEvents}" var="event">
        <tr>
            <td>${event.description}</td>
            <td>${event.date}</td>
            <td><a href="/event/stats/${event.id}">Show stats</a></td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
