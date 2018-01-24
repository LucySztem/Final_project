<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 23.01.18
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored = "false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <%--@elvariable id="food" type="pl.coderslab.entity.Food"--%>
    <form:form action="/food/add" method="post" modelAttribute="food">


        Type<form:select path="type">
        <form:options items="${types}"/>
        </form:select><br>

        Amount<form:input path="amount"/><br>
        Price<form:input path="price"/><br>

        <input type="submit" value = "Add food">
    </form:form>
</div>

</body>
</html>
