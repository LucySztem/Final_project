<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<body>

<h1 align="center">Fiesta!</h1>
<div>
    <h3 align="center"><a href="/user/add">Register</a></h3>
    <div id="login">
        <jsp:include page="WEB-INF/views/login_form.jsp"></jsp:include>
    </div>
</div>
</body>
<link rel="stylesheet" href="resources/css/homepage.css">
</html>
