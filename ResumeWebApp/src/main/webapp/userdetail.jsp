<%-- 
    Document   : user
    Created on : 30 Eyl 2022, 18:34:33
    Author     : 99470
--%>
<%@page import="com.company.entity.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/details.css">
</head>
<body>
<%
    User u = (User) request.getAttribute("user");
%>
<section class="section gray-bg" id="about">
<div class="container">
    <div class="row align-items-center flex-row-reverse">
        <div class="col-lg-6">
            <div class="about-text go-to">
            <h3 class="dark-color">About Me</h3>
            <h6 class="theme-color lead">Backend Developer</h6>
            <p><%=u.getProfileDescription()%></p>
                <div class="row about-list">
                    <div class="col-md-6">
                        <div class="media">
                            <label>name</label>
                            <p><%=u.getName()%></p>
                        </div>
                        <div class="media">
                            <label>surname</label>
                            <p><%=u.getSurname()%></p>
                        </div>
                        <div class="media">
                            <label>phone</label>
                            <p><%=u.getPhone()%></p>
                        </div>
                        <div class="media">
                            <label>Nationality</label>
                            <p><%=u.getNationality().getNationality()%></p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="media">
                            <label>Address</label>
                            <p><%=u.getAddress()%></p>
                        </div>
                        <div class="media">
                            <label>BirthDate</label>
                            <p><%=u.getBirthDate()%></p>
                        </div>
                        <div class="media">
                            <label>BirthPlace</label>
                            <p><%=u.getBirthPlace().getName()%></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="about-avatar">
                <img src="https://media-exp1.licdn.com/dms/image/C4E03AQEwiEHAn1nBcw/profile-displayphoto-shrink_800_800/0/1534963043653?e=2147483647&v=beta&t=jmcIVxTU0P68jxNsDT2skZe3ymt2lffi0p4A66hEgvE" title="" alt="">
            </div>
        </div>
    </div>
</div>
</section>
</body>
</html>
