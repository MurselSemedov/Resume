<%-- 
    Document   : details
    Created on : 30 Eyl 2022, 21:22:19
    Author     : 99470
--%>

<%@page import="com.company.entity.User"%>
<%@page import="com.company.main.Context"%>
<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <%
        UserDaoInter userDao = Context.instanceUserDao();
        User user = userDao.getById(Integer.valueOf(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
    %>
<div>
    <form action="UserController" method="POST">
        <input type="hidden" name="id" value="<%=user.getId()%>"/>
        <input type="hidden" name="name" value="<%=user.getName()%>"/>
        <input type="hidden" name="surname" value="<%=user.getSurname()%>"/>
        <label for="address">Address</label>
        <input type="text" name="address" value="<%=user.getAddress()%>"/>
        <br/>
        <label for="phone">Phone</label>
        <input type="text" name="phone" value="<%=user.getPhone()%>"/>
        <br/>
        <label for="email">Email</label>
        <input type="text" name="email" value="<%=user.getEmail()%>"/>
        <br/>
        <label for="birthdate">Birthdate</label>
        <input type="text" name="birthdate" value="<%=user.getBirthDate()%>"/>
        <input type="submit" name="save" value="Save"/>
    </form>
</div>
</body>
</html>
