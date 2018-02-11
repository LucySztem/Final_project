<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>


<body style="background-color: #F0DDD1;">

<h1 align="center" style="font-family: Georgia; font-size: 150px">Fiesta!</h1>

<div>

    <h3 align="center"><a href="/user/add">Register</a></h3>

    <div class="container">

        <form action="/user/login" method="post" class="form-horizontal">

            <div class="form-group">
                <label class="control-label col-sm-2" for="username">Username:</label>
                <div class="col-sm-4">
                    <input name="username" id="username" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="password">Password:</label>
                <div class="col-sm-4">
                    <input type="password" id="password" name="password" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success">Log in</button>
                </div>
            </div>
        </form>
    </div>

</div>
</body>

</html>
