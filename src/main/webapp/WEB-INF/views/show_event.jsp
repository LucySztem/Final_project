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
    <link rel="stylesheet" href="/resources/css/show_event.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<h3><a href="/event/all">Go back</a></h3><br>
<table class="table table-striped">
    <thead>
    <tr>
        <td>id</td>
        <td>Description</td>
        <td> Place</td>
        <td>Date</td>
        <td>People</td>
        <td>Update</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${event.id}</td>
        <td>${event.description}</td>
        <td>${event.place}</td>
        <td>${event.date}</td>
        <td>${event.people}</td>
        <td><a href="/event/update/${event.id}">Change information</a></td>
    </tr>

    </tbody>
</table>


<div id="first">
    <jsp:include page="food/add_food_form.jsp"/>
</div>
<div id="second">
    <jsp:include page="drink/add_drink_form.jsp"/>
</div>

<div id="partyDrinks">
    <h2> Drinks summary </h2>
    <table class="table table-striped">
        <tr>
            <td>Name</td>
            <td>Amount</td>
            <td>Price</td>
            <td>Who is brining it</td>
            <td>Action</td>

        </tr>
        <c:set var="total" value="${0.0}"/>
        <c:forEach items="${drinks}" var="drink">
            <tr>
                <td>${drink.name}</td>
                <td>${drink.amount}</td>
                <td>${drink.price}</td>
                <td>${drink.person}</td>
                <td><a href="/drink/update/${drink.id}">Update</a> || <a href="/drink/delete/${drink.id}/${event.id}">Delete</a></td>
            </tr>
        </c:forEach>
        <c:set var="total" value="${0.0}"/>
        <c:forEach items="${drinks}" var="drink">
        <c:set var="total" value="${total +drink.price}"/>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td>SUM: <c:out value="${total}"/></td>
        </tr>

    </table>
</div>
<div id="partyFood">
    <h2>Food Summary</h2>
    <table class="table table-striped">
        <tr>
            <td>Name</td>
            <td>Amount</td>
            <td>Total price</td>
            <td>Who is brining it</td>
            <td>Action</td>
        </tr>
        <c:forEach items="${foods}" var ="food">
        <tr>
            <td>${food.name}</td>
            <td>${food.amount}</td>
            <td>${food.price}</td>
            <td>${food.person}</td>
            <td><a href="/food/update/${food.id}">Update</a> || <a href="/food/delete/${food.id}/${event.id}">Delete</a></td>
        </tr>
        </c:forEach>
        <c:set var="total" value="${0.0}"/>
        <c:forEach items="${foods}" var="food">
            <c:set var="total" value="${total +food.price}"/>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td>SUM: <c:out value="${total}"/></td>
        </tr>
    </table>
</div>
</body>

</html>
