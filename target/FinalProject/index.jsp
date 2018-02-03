<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>


<body style="background-color: #CCBEE9;">

<h1 align="center">Fiesta!</h1>

<div id="container" align="center">
    <%--<h3 align="center"><a href="/event/add">Add new party</a></h3>--%>
    <%--<h3 align="center"><a href="/event/all">Show all parties</a></h3>--%>

    <h3 align="center"><a href="/user/add">Register</a></h3>
    <%--<h3 align="center"><a href="/user/login">Log in</a></h3>--%>
    <div id="login">
        <jsp:include page="WEB-INF/views/login_form.jsp"/>
    </div>

</div>
</body>

</html>
