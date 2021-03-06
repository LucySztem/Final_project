<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


<html>
<head>
    <title>Stats</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/event_stats.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Stats for ${event.description}</h1>
<div id="eventBtId" width ="500px">
    <c:set var="totalAlcohol" value="${0.0}"/>
    <c:set var="totalSoft" value="${0.0}"/>
    <c:set var="totalSnacks" value="${0.0}"/>
    <c:set var="totalHot" value="${0.0}"/>
    <c:forEach items="${alcohol}" var="alcohol">
        <c:set var="totalAlcohol" value="${totalAlcohol +alcohol.price}"/>
    </c:forEach>
    <c:forEach items="${soft}" var="softDrink">
        <c:set var="totalSoft" value="${totalSoft +softDrink.price}"/>
    </c:forEach>
    <c:forEach items="${snacks}" var="snack">
        <c:set var="totalSnacks" value="${totalSnacks +snack.price}"/>
    </c:forEach>
    <c:forEach items="${hotFood}" var="hotFood">
        <c:set var="totalHot" value="${totalHot +hotFood.price}"/>
    </c:forEach>
    <table class="table table-striped">
        <tr>
            <td>People</td>
            <td>Hot Food</td>
            <td>Snacks</td>
            <td>Alcohol</td>
            <td>Soft drinks</td>
        </tr>
        <tr>
            <td>${event.people}</td>
            <td><c:out value="${totalHot} zl"/> </td>
            <td><c:out value="${totalSnacks} zl"/></td>
            <td><c:out value="${totalAlcohol} zl "/></td>
            <td><c:out value="${totalSoft} zl"/></td>
        </tr>
    </table>
</div>

<div id="summary">
    <table class="table table-striped">
        <tr>
            <td>Type</td>
            <td>Price per person</td>
        </tr>
        <tr>
            <td>Hot food</td>
            <td>${totalHot/event.people} zl</td>
        </tr>
        <tr>
            <td>Snacks</td>
            <td>${totalSnacks/event.people} zl</td>
        </tr>
        <tr>
            <td>Alcohol</td>
            <td>${totalAlcohol/event.people} zl</td>
        </tr>
        <tr>
            <td>Soft drinks</td>
            <td>${totalSoft/event.people} zl</td>
        </tr>
    </table>
</div>
<div id="return">
    <a href="/event/all">Return to all events</a>

</div>
</body>
</html>
