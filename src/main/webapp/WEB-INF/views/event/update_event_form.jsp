<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>
<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 26.01.18
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>

<html>

<head>
    <title>Update ifnormation</title>
    <style>
        .container{
            position: absolute;
            width: 1500px;
            height: 1500px;
            z-index: 15;
            top: 50%;
            left: 50%;
            margin: -100px 0 0 -150px;

        }
        h1{
            color: steelblue;
        }
    </style>
</head>
<body>

<div class = "container">
    <h1>Update information</h1>
<%--@elvariable id="event" type="pl.coderslab.entity.Event"--%>
<form:form action="/event/update" method="post" modelAttribute="event" class="form-horizontal">
    <form:hidden path="id"/>

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
            <button type="submit" class="btn btn-success">Update!</button>
        </div>
    </div>
</form:form>
</div>
</body>
</html>
