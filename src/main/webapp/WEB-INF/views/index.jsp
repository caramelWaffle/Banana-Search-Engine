<%--
  Created by IntelliJ IDEA.
  User: tanachat_a
  Date: 10/25/2018
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %><html>

<head>
    <title>Literature Searching</title>

    <link rel="stylesheet" type="text/css"
          href='<c:url value="/css/bootstrap.min.css" />'/>

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-light bg-light static-top">
    <div class="container">
        <a class="navbar-brand" href="<c:url value="/index" />"><img src="img/logo-small.png" width="60" height="auto" class="d-inline-block align-top" alt="">  Banana Search</a>
        <a class="btn btn-primary" href="#">Welcome ${sessionScope.user}</a>
    </div>
</nav>

<!-- Masthead -->
<header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container" style="margin-top: 10%">
        <div class="row">
            <div class="col-md-9 mx-auto">
                <img src="img/logo-small.png" width="300" height="auto" class="d-inline-block align-top" alt="" style="margin-top:-70px">
                <!-- <h1 class="mb-5">Search paper here!</h1> -->
            </div>
            <div class="col-md-10 col-lg-8 col-xl-7 mx-auto mt-2">
                <form action = "result" method = "GET">
                    <div class="form-row" style="margin-top: 20px">
                        <div class="col-12 col-md-9 mb-2 mb-md-0">
                            <input type="keyword" class="form-control form-control-lg" name="q" placeholder="Search keyword">
                        </div>
                        <div class="col-12 col-md-3">
                            <button type="submit" value="Submit" class="btn btn-block btn-lg btn-primary">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</header>

<!-- Footer -->
<footer class="footer bg-light" style="margin-top: 12%">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 text-center text-lg-left my-auto">
                <ul class="list-inline mb-2">
                    <li class="list-inline-item">
                        <a href="#">About</a>
                    </li>
                    <li class="list-inline-item">&sdot;</li>
                    <li class="list-inline-item">
                        <a href="#">Contact</a>
                    </li>
                    <li class="list-inline-item">&sdot;</li>
                    <li class="list-inline-item">
                        <a href="#">Terms of Use</a>
                    </li>
                    <li class="list-inline-item">&sdot;</li>
                    <li class="list-inline-item">
                        <a href="#">Privacy Policy</a>
                    </li>
                    <li class="list-inline-item">
                        <a href="<c:url value="/logout" />">Logout</a>
                    </li>
                </ul>
                <p class="text-muted small mb-4 mb-lg-0">&copy; Banana search engine 2018. All Rights Reserved.</p>
            </div>
            <div class="col-lg-6 text-center text-lg-right my-auto">
                <ul class="list-inline mb-0">
                    <li class="list-inline-item mr-3">
                        <a href="#">
                            <i class="fab fa-facebook fa-2x fa-fw"></i>
                        </a>
                    </li>
                    <li class="list-inline-item mr-3">
                        <a href="#">
                            <i class="fab fa-twitter-square fa-2x fa-fw"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">
                            <i class="fab fa-instagram fa-2x fa-fw"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>

</body>
</html>
