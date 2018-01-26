<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored = "false" %>
<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 23.01.18
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Add Event Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Create new Event</h1>
<div class = "conntainer">
<%--@elvariable id="event" type="pl.coderslab.entity.Event"--%>
<form:form action="/event/add" method = "post" modelAttribute="event" class="form-horizontal">


        <div class="form-group">
            <label class="control-label col-sm-2" for="description">Type of party:</label>
            <div class="col-sm-4">
                <form:input path="description" class="form-control" placeholder="Houseparty at..."/>
            </div>
        </div>

    <div class="form-group">
        <label class="control-label col-sm-2" for="place">Where:</label>
        <div class="col-sm-4">
            <form:input path="place" class="form-control" placeholder="Enter address for this googlemaps action"/>
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-sm-2" for="date">When:</label>
        <div class="col-sm-4">
            <form:input path="date" class="form-control" placeholder="yyyy-mm-dd"/>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-sm-2" for="people">How many people is coming:</label>
        <div class="col-sm-4">
            <form:input path="people" class="form-control" />
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success">Party!</button>
        </div>
    </div>
</form:form>
</div>
</body>
</html>
