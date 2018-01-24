<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 23.01.18
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored = "false" %>
<html>
<head>
    <title>Add drink form</title>
</head>
<body>
<div>
<%--@elvariable id="drink" type="pl.coderslab.entity.Drink"--%>
<form:form action="/drink/add" method="post" modelAttribute="drink">

Type: <form:input path="type"/><br>
    Name<form:input path="name"/><br>
    Amount<form:input path="amount"/><br>
    Price<form:input path="price"/><br>

    <input type="submit" value = "Add drink">
</form:form>
</div>
</body>
</html>
