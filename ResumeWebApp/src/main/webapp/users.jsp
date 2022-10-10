<%-- 
    Document   : user
    Created on : 30 Eyl 2022, 18:34:33
    Author     : 99470
--%>

<%@page import="com.company.main.Context" %>
<%@page import="com.company.dao.inter.UserDaoInter" %>
<%@page import="com.company.entity.User" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/9c2a17abb7.js" crossorigin="anonymous"></script>
</head>
<body>
<%
    UserDaoInter userDao = Context.instanceUserDao();
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String nIdStr = request.getParameter("nId");
    Integer nationalityId = null;
    if (nIdStr != null && !nIdStr.trim().isEmpty()) {
        nationalityId = Integer.parseInt(nIdStr);
    }
    List<User> list = userDao.getAllUser(name, surname, nationalityId);
%>
<div class="container my_container">
    <div class="col-4">
        <form action="users.jsp" method="GET">
            <div class="form-group">
                <label>name:</label>
                <input type="text" class="form-control" name="name" value="" placeholder="Enter name"/>
            </div>
            <div class="form-group">
                <label>surname:</label>
                <input type="text" class="form-control" name="surname" value="" placeholder="Enter surname"/>
            </div>
            <input type="submit" class="btn btn-primary" name="search" value="Search"/>
        </form>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>name</th>
                <th>surname</th>
                <th>nationality</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <%
                for (User u : list) {
            %>
            <tr>
                <td><%=u.getName()%>
                </td>
                <td><%=u.getSurname()%>
                </td>
                <td><%=u.getNationality().getNationality() == null ? "N/A" : u.getNationality().getNationality()%>
                </td>
                <td>

                    <button class="btn btn-danger" type="submit" name="delete" value="Delete">
                        <i class="fa-solid fa-trash-can" ></i>
                    </button>
                    <button class="btn btn-secondary" type="submit" name="update" value="Update" >
                        <i class="fa-solid fa-square-pen "></i>
                    </button>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
