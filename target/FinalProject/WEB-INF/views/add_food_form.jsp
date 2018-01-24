<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 23.01.18
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <%--@elvariable id="food" type="pl.coderslab.entity.Food"--%>
    <form:form action="/food/add" method="post" modelAttribute="food">


        Name<form:input path="name"/><br>
        Amount<form:input path="amount"/><br>
        Price<form:input path="price"/><br>

        <input type="submit" value = "Add drink">
    </form:form>
</div>

</body>
</html>
