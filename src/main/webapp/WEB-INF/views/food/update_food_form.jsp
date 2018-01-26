<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored = "false" %>
<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 26.01.18
  Time: 13:05
  To change this template use File | Settings | File Templates.
<html>
--%>

<head>
    <title>Update Food</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class = "container">
    <h1 style="color:darkmagenta" align="left">Food</h1>
    <%--@elvariable id="food" type="pl.coderslab.entity.Food"--%>
    <form:form action="/food/add" method="post" modelAttribute="food" class="form-horizontal">
        <form:hidden path="event.id"/>
        <form:hidden path="id"/>
        <div class="form-group">
            <label class="control-label col-sm-2" for="type">Type:</label>
            <div class="col-sm-4">
                <form:select path="type">
                    <form:options items="${types}"/>
                </form:select>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="amount">Amount:</label>
            <div class="col-sm-4">
                <form:input path="amount" class="form-control" placeholder="Enter amount"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="price">Total price</label>
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
                <button type="submit" class="btn btn-success">Add food</button>
            </div>
        </div>

    </form:form>
</div>


</body>
</html>
