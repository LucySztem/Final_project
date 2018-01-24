<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 24.01.18
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Event 01</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-striped">
    <thead>
    <tr>
        <td>id</td>
        <td>Description</td>
        <td> Place</td>
        <td>Date</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${event.id}</td>
        <td>${event.description}</td>
        <td>${event.place}</td>
        <td>${event.date}</td>
    </tr>
    </tbody>
</table>
<div class="container">
    <div style="float:left">
    <h2>Add yummy stuff</h2>
<jsp:include page="add_food_form.jsp"/>
</div>
<div style="float: right; margin-left: 10px;">
    <jsp:include page="add_drink_form.jsp"/>
</div>
</div>
</body>
</html>
