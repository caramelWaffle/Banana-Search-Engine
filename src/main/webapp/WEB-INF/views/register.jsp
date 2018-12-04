<%--
  Created by IntelliJ IDEA.
  User: tanachat_a
  Date: 10/25/2018
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>

    <link rel="stylesheet" type="text/css"
          href='<c:url value="/css/bootstrap.min.css" />'/>

    <link rel="stylesheet" type="text/css"
          href='<c:url value="/css/register_css.css" />'/>
    
</head>
<script type="text/javascript">
	var register_msg= "${requestScope.register_msg}";
	if(register_msg){
		alert(register_msg);
	}
</script>
<body id="LoginForm">

<div>
<section class="register-block">
    <div class="container">
        <div class="row">
            <div class="col-md-4 register-sec">
                <h2 class="text-center">Register Now</h2>
                <form:form class="register-form" action="/registerSave" method="post">
                	<div class="form-group">
                        <label for="exampleInputUsername" class="text-uppercase">Username</label>
                        <input type="text" name="C_USER_NAME" required="required" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1" class="text-uppercase">Password</label>
                        <input type="password" name="C_USER_PWD" required="required" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputAddress1" class="text-uppercase">Address Line 1</label>
                        <input type="address1" name="C_ADDRESS_LINE1" required="required" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputAddress2" class="text-uppercase">Address Line 2</label>
                        <input type="address2" name="C_ADDRESS_LINE2" required="required" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputTown1" class="text-uppercase">Town</label>
                        <input type="town" name="C_TOWN" required="required" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputCountry1" class="text-uppercase">Country</label>
                        <input type="country" name="C_COUNTRY" required="required" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPostCode1" class="text-uppercase">Post Cod/Zip</label>
                        <input type="postcode" name="C_POST" required="required" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputName1" class="text-uppercase">Name</label>
                        <input type="name" name="C_NAME" required="required" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail" class="text-uppercase">Email</label>
                        <input type="email" name="C_EMAIL" required="required" class="form-control" placeholder="">
                    </div>

                    <div class="form-check">
                        <button type="submit" class="btn btn-register float-right">Submit</button>
                    </div>

                    <div>
                        <a href="<c:url value="/login" />">Already have account</a>
                    </div>

                </form:form>

            </div>
            <div class="col-md-8 banner-sec">
            </div>
        </div>
    </div>
</section>
</div>
</body>
</html>
