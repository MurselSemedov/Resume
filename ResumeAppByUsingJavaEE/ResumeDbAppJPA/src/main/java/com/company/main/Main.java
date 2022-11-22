/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.main;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import org.hibernate.ejb.HibernatePersistence;
import java.util.List;

/**
 *
 * @author 99470
 */
public class Main {
    public static SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) throws ParseException {
        UserDaoInter dao = Context.instanceUserDao();
        User user = dao.getById(12);
        System.out.println(user.getName());
    }
}
