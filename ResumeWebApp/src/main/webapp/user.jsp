<%-- 
    Document   : user
    Created on : 30 Eyl 2022, 18:34:33
    Author     : 99470
--%>

<%@page import="com.company.main.Context"%>
<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@page import="com.company.entity.User"%>
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
        User u = userDao.getById(7);
    %>
<div>
    <form action="user.jsp" method="POST">
        <input type="hidden" name="id" value="<%=u.getId()%>"/>
        <label >name</label>
            <input type ="text" name="name" value="<%=u.getName()%>"/>
                <br/>
        <label>surname</label>
            <input type="text" name="surname" value="<%=u.getSurname()%>"/>
        <input type="submit" name="next" value="Next"/>
    </form>
</div>

</body>
</html>
