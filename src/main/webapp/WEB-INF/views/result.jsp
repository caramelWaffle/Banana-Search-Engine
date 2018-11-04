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
    <title>${keyword} | Literature Searching</title>

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
        <a class="btn btn-primary" href="<c:url value="/login" />">Welcome Skaworld</a>
    </div>

</nav>

<!-- Masthead -->
<header class="text-black" style="margin-top:20px;">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-2 linespace" >
                <a class="text-danger" href="#">Any time</a><br>
                <a class="text-dark" href="#">Since 2018</a><br>
                <a class="text-dark" href="#">Since 2017</a><br>
                <a class="text-dark" href="#">Since 2014</a><br>
                <a class="text-dark" href="#">Custom range...</a><br>
                <hr>
                <a class="text-danger" href="#">Sort by relevance</a><br>
                <a class="text-dark" href="#">Sort by date</a><br>
                <hr>
                <form>
                    <div class="checkbox">
                        <label><input type="checkbox" value="">include parents</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" value="">include citations</label>
                    </div>
                </form>
                <hr>
            </div>

            <div class="col-md-8" >

                <c:choose>
                    <c:when test="${empty keyword}">
                        <p>search paper</p>
                        <form action = "search" method = "GET">
                            Search: <input type = "text" name = "q" />
                            <input type = "submit" value = "Submit" />
                        </form>
                    </c:when>


                    <c:otherwise>
                        <h1><p>The results of "${keyword}"</p></h1>
                        <c:forEach items="${results}" var="result">

                            <form action = "/info" method = "GET">
                                <input type="hidden" name="author" value="${result.info.authors.author}">
                                <input type="hidden" name="title" value="${result.info.title}">
                                <input type="hidden" name="venue" value="${result.info.venue}">
                                <input type="hidden" name="volume" value="${result.info.volume}">
                                <input type="hidden" name="pages" value="${result.info.pages}">
                                <input type="hidden" name="year" value="${result.info.year}">
                                <input type="hidden" name="type" value="${result.info.type}">
                                <input type="hidden" name="doi" value="${result.info.doi}">
                                <input type="hidden" name="key" value="${result.info.key}">
                                <input type="hidden" name="ee" value="${result.info.ee}">
                                <input type="hidden" name="url" value="${result.info.url}">
                                <button class="btn-link" type="submit" value="Submit">${result.info.title}</button>
                            </form>

                                <%--<a href="#">${result.info.title}</a><br>--%>
                                <p class="font-weight-light" style="font-size:13px; color: green; display:inline">${result.info.type} - ${result.info.key}</p>
                                    <%--<p class="font-weight-light" style="font-size:13px; color:black">${result.info.type} - ${result.info.key}</p>--%>
                                <p class="font-weight-light" style="font-size:13px; color:black;display:inline">${result.info.doi}</p>
                                <p class="font-weight-light" style="font-size:13px; color:black">REF : <a style="color: #1d2124" href="${result.info.ee}">${result.info.ee}</a></p>

                        </c:forEach>
                    </c:otherwise>
                </c:choose>



            </div>
        </div>
    </div>
</header>

<!-- Footer -->
<footer class="footer bg-light">
    <div class="container" style="margin-top: 15%">
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
                <p class="text-muted small mb-4 mb-lg-0">&copy; Your Website 2018. All Rights Reserved.</p>
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
