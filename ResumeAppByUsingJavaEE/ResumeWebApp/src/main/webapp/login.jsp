<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 99470
  Date: 10.10.2022
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="wrapper">
    <div>
        <img class="logo" src="https://seeklogo.com/images/C/cv-comunidad-valenciana-logo-CD417D951E-seeklogo.com.png"
             alt="">
    </div>
    <div>
        <form action="login" method="POST" class="p-3 mt-3">
            <div class="form-field d-flex align-items-center">
                <span class="far fa-user"></span>

                <input placeholder="Enter email" type="text" name="email" value="">
            </div>
            <div class="form-field d-flex align-items-center">
                <span class="fas fa-key"></span>
                <input class="form-control" placeholder="Enter password" type="password" name="password" value="">
            </div>
            <p><a href>Forgot password?</a></p>
            <button class="btn mt-3">Login</button>
        </form>
    </div>
    <div>
        <p>Don't have an account? <a href>Sign Up</a></p>
    </div>
</div>
</body>
</html>
