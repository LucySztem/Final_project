<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 26.01.18
  Time: 08:35
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Loging </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

    <form:form action="/drink/add" method="post" modelAttribute="" class="form-horizontal">

    <div class="form-group">
    <label class="control-label col-sm-2" for="username">Username:</label>
        <div class="col-sm-4">
            <form:input path="username" class="form-control" />
        </div>
    </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password:</label>
            <div class="col-sm-4">
                <form:password path="password" class="form-control" />
            </div>
        </div>

    </form:form>
</div>

</body>
</html>
