<%-- 
    Document   : user
    Created on : 30 Eyl 2022, 18:34:33
    Author     : 99470
--%>

<%@page import="com.company.entity.User" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/9c2a17abb7.js" crossorigin="anonymous"></script>
    <script type="text/javascript" src="assets/js/users.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<%
        List<User> list = (List<User>) request.getAttribute("users");
%>
<div class="container my_container">
    <div class="col-4">
        <form action="users" method="GET">
            <div class="form-group">
                <label>name:</label>
                <input  type="text" class="form-control" name="name" value="" placeholder="Enter name" />
            </div>
            <div class="form-group">
                <label>surname:</label>
                <input type="text" class="form-control" name="surname" value="" placeholder="Enter surname"/>
            </div>
            <input id="srcId"  type="submit" class="btn btn-primary" name="search" value="Search"/>
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
                <th></th>
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
                    <div >
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value=<%=u.getId()%>>
                        <button  class="btn btn-danger" type="button" value="delete" data-toggle="modal" data-target="#exampleModal"
                        onclick="setIdForDelete(<%=u.getId()%>)">
                            <i class="fa-solid fa-trash-can"></i>
                        </button>
                    </div>
                </td>
                <td>
                    <form action="userdetail" method="GET" style="width: 5px">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="id" value=<%=u.getId()%>>
                        <button class="btn btn-secondary" type="submit" value="update">
                            <i class="fa-solid fa-square-pen "></i>
                        </button>
                    </form>
                </td>
                <td>
                    <form action="userdetail" method="GET">
                        <input type="hidden" name="action" value="info">
                        <input type="hidden" name="id" value=<%=u.getId()%>>
                        <button class="btn btn-info" type="submit" value="info">
                            <i class="fa-solid fa-circle-info"></i>
                        </button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <form action="userdetail" method="POST">
                    <input id="setId" type="hidden" name="id" value="">
                    <input type="hidden" name="action" value="delete">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
