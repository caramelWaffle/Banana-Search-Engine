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
    <title>${title} | Literature Searching</title>

    <link rel="stylesheet" type="text/css"
          href='<c:url value="/css/bootstrap.min.css" />'/>

    <link rel="stylesheet" type="text/css"
          href='<c:url value="/css/btn_link.css" />'/>

</head>

<body>


<!-- Navigation -->
<nav class="navbar navbar-light bg-light static-top">
    <div class="container">
        <a class="navbar-brand" href="<c:url value="/index" />"><img src="img/logo-small.png" width="60" height="auto" class="d-inline-block align-top" alt="">  Banana Search</a>

        <form action = "result" method = "GET">
            <div class="form-row" >
                <div class="col-12 col-md-9 mb-2 mb-md-0">
                    <input type="keyword" value="${keyword}" name="q" class="form-control form-control-lg" style ="height: 38px;width: 500px;" placeholder="Search keyword">
                </div>
                <div class="col-12 col-md-3">
                    <button type="submit" value="Submit" class="btn btn-primary">Search</button>
                </div>
            </div>
        </form>
        <a class="btn btn-primary" href="<c:url value="/login" />">Welcome ${sessionScope.user}</a>
    </div>

</nav>

<!-- Masthead -->
<header class="text-black" style="margin-top:20px;">
    <div class="overlay"></div>
    <div class="container">


        <div class="card card-body">
            <dl class="row">

                <dt class="col-sm-1">Title</dt>
                <dd class="col-sm-11">${title}</dd>

                <dt class="col-sm-1">Authors</dt>
                <dd class="col-sm-11">${author}</dd>

                <dt class="col-sm-1">Venue</dt>
                <dd class="col-sm-11">${venue}</dd>

                <dt class="col-sm-1">Volume</dt>
                <dd class="col-sm-11">${volume}</dd>

                <dt class="col-sm-1">Pages</dt>
                <dd class="col-sm-11">${pages}</dd>

                <dt class="col-sm-1">Year</dt>
                <dd class="col-sm-11">${year}</dd>

                <dt class="col-sm-1">Type</dt>
                <dd class="col-sm-11">${type}</dd>

                <dt class="col-sm-1">Key</dt>
                <dd class="col-sm-11">${key}</dd>

                <dt class="col-sm-1">DOI</dt>
                <dd class="col-sm-11">${doi}</dd>

                <dt class="col-sm-1">EE</dt>
                <dd class="col-sm-11"><a href="${ee}">${ee}</a></dd>

                <dt class="col-sm-1">URL</dt>
                <dd class="col-sm-11"><a href="${url}">${url}</a></dd>




            </dl>

        </div>

    </div>
</header>

<!-- Footer -->
<footer class="footer bg-light">
    <div class="container" style="margin-top: 5%">
        <div class="row">
            <div class="col-lg-6  text-center text-lg-left my-auto">
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
                </ul>
                <p class="text-muted small mb-4 mb-lg-0">&copy; Banana search engine 2018. All Rights Reserved.</p>
            </div>
            <div class="col-lg-6  text-center text-lg-right my-auto">
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

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
