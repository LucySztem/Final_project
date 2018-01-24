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
<style>
    table, th, td {
        border: 1px solid forestgreen;
        border-collapse: collapse;
    }

</style>

<head>
    <title>Events</title>
</head>
<body>
<table>
    <tr>
        <td>Id</td>
        <td>What</td>
        <td>Where</td>
        <td>When</td>
    </tr>
    <c:forEach items="${events}" var ="event">
    <tr>
        <td>${event.id}</td>
        <td>${event.description}</td>
        <td>${event.place}</td>
        <td>${event.date}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
