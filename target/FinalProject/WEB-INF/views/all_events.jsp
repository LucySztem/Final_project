<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 23.01.18
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Events</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function ($) {
            $(".table-row").click(function () {
                window.document.location = $(this).data("href");
            });
        });
    </script>
    <style type="text/css">
        .table-row {
            cursor: pointer;
        }
    </style>

</head>
<body>
<div class="container">
<table class="table table-striped">
    <thead class="thead-dark">
    <tr>
        <td>Id</td>
        <td>What</td>
        <td>Where</td>
        <td>When</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${events}" var="event">
        <tr class="table-row" data-href="/event/${event.id}">
            <td>${event.id}</td>
            <td>${event.description}</td>
            <td>${event.place}</td>
            <td>${event.date}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>

</html>
