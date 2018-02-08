<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 02.02.18
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Add new comment</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<%--@elvariable id="comment" type="pl.coderslab.entity.Comment"--%>
<form:form action="/comment/add" method="post" modelAttribute="comment" >
    <h3>Enter text</h3>
    <form:textarea path="text" />
    <input type="submit" value="send">
</form:form>
</div>
</body>
</html>
