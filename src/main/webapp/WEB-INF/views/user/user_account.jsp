<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 03.02.18
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>My account</title>
</head>
<body>
<p> ${user.getId()}</p>
<table>
    <tr>
        <td> Parties you have hosted</td>
        <td> Date</td>

    </tr>
<c:forEach items="${list}" var="event">
    <tr>
        <td>${event.description}</td>
        <td>${event.date}</td>
    </tr>

</c:forEach>
</table>
</body>
</html>
