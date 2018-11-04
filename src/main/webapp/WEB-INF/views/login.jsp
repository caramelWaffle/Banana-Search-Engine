<%--
  Created by IntelliJ IDEA.
  User: tanachat_a
  Date: 10/25/2018
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" type="text/css"
          href='<c:url value="/css/bootstrap.min.css" />'/>

    <link rel="stylesheet" type="text/css"
          href='<c:url value="/css/login_css.css" />'/>
</head>

<body id="LoginForm">
<div class="container">
    <h1 class="form-heading">Banana Literature Searching</h1>
    <div class="login-form">
        <div class="main-div">
            <div class="panel">
                <h2>Login Form</h2>
                <p>Please enter your username and password</p>
            </div>
        <form:form cssClass="form" action="/login" method="POST">

                <div class="form-group">


                    <input type="text" class="form-control" id="inputEmail" placeholder="Username" name="username">

                </div>

                <div class="form-group">

                    <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">

                </div>


                <button type="submit" class="btn btn-primary" value="Login">Login</button>

        </form:form>

            <div class="forgot">
                <div>
                    <a href="">Forgot password?</a>
                </div>
                <div>
                    <a href="<c:url value="/register" />">Don't have account?</a>
                </div>
            </div>

        </div>
    </div>
</div>
</div>


</body>
</html>
