
<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 23.01.18
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored = "false" %>

<html>
<head>
    <title>Add Event Form</title>
</head>
<body>
<h1>Create new Event</h1>
<%--@elvariable id="event" type="pl.coderslab.entity.Event"--%>
<form:form action="/event/add" method = "post" modelAttribute="event">
    <div>
    <p> What type of party is it? <form:input path="description"/></p><br>
    <p> Where? <form:input path="place"/></p><br>
    <p> When? <form:input path="date"/></p><br>
    </div>

    <input type="submit" value="Send">
</form:form>

</body>
</html>
