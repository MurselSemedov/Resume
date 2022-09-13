/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import bean.User;
import dao.inter.UserDaoInter;


public class Main {
    
    

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = Context.instanceUserDao();
        User u =userDao.getById(1);
        u.setSurname("Samadov");
        userDao.updateUser(u);
    }
}
