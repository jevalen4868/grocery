<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="ss" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>grocery - login</title>
</head>
<body>
<div class="container">
    <!-- Using spring form here is not recommended. -->
    <form action="/grocery/login" method="POST" class="form-signin">
        <!-- 		This guy handles the csrf include for us. -->
        <ss:csrfInput/>
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label> <input
            type="email" id="inputEmail" name="username" class="form-control"
            placeholder="Email address" required="true" autofocus="true"/> <label
            for="inputPassword" class="sr-only">Password</label> <input
            type="password" id="inputPassword" class="form-control"
            placeholder="Password" name="password" required="true"/>
        <div class="checkbox">
            <label path="remember-me"> <input type="checkbox"
                                              id="remember_me" path="remember-me" name="remember-me"
                                              value="remember-me"/> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign
            in
        </button>
    </form>
</div>
<!-- /container -->
</body>
</html>