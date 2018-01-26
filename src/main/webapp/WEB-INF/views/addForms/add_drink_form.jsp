<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 23.01.18
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add drink form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1 style ="color:darkmagenta">Drinks</h1>
    <%--@elvariable id="drink" type="pl.coderslab.entity.Drink"--%>
    <form:form action="/drink/add" method="post" modelAttribute="drink" class="form-horizontal">
        <form:hidden path="event.id"/>
        <div class="form-group">
            <label class="control-label col-sm-2" for="type">Type:</label>
            <div class="col-sm-4">
                <form:select path="type">
                    <form:options items="${types}"/>
                </form:select>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name:</label>
            <div class="col-sm-4">
                <form:input path="name" class="form-control" placeholder="Enter name"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="amount">Amount:</label>
            <div class="col-sm-4">
                <form:input path="amount" class="form-control" placeholder="How much"/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="price">Price:</label>
            <div class="col-sm-4">
                <form:input path="price" class="form-control" placeholder="Enter total price"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="person">Who is bringing it</label>
            <div class="col-sm-4">
                <form:input path="person" class="form-control" placeholder="Enter your name"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Add drinks</button>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
