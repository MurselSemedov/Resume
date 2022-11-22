/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.company.resume.controller;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author 99470
 */
@WebServlet(name = "UserController", urlPatterns = {"/users"})
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String nIdStr = request.getParameter("nId");
            Integer nationalityId = null;
            if (nIdStr != null && !nIdStr.trim().isEmpty()) {
                 nationalityId = Integer.parseInt(nIdStr);
            }
            UserDaoInter userDao = Context.instanceUserDao();
            List<User> list = userDao.getAllUser(name, surname, nationalityId);
            if (list.isEmpty() || list.get(0)==null) {
                throw new IllegalArgumentException("There is not user with name,surname and nationality id");
            }
            request.setAttribute("users",list);
            request.getRequestDispatcher("users.jsp").forward(request, response);
        }catch (Exception ex){
            ex.printStackTrace();
            request.getRequestDispatcher("error.jsp?msg="+ex.getMessage()+"&back=users").forward(request,response);
        }
    }

}
