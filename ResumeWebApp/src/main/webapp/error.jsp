<%--
  Created by IntelliJ IDEA.
  User: 99470
  Date: 14.10.2022
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Why are you here?</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/error.css">
</head>
<body>
<div class="gray-bg container">
<div class="div-pos row align-items-center flex-row-reverse">
<div  class="col-lg-6 notfound-copy">
    <h1 style="font-size: 200px;margin-bottom: 10px">404</h1>
    <h1 class="col"><%=request.getParameter("msg")%></h1>
    <p><a class="btn btn-warning" href="<%=request.getParameter("back")%>">Back</a></p>
</div>
<div class="col-lg-6 img-pos">
    <img src="https://gradship.com.au/wp-content/uploads/2020/10/Recume-review.png" alt="" >
</div>
</div>
</div>
</body>
</html>
