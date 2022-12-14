/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.User;
import java.util.List;

/**
 *
 * @author 99470
 */
public interface UserDaoInter {
    public List<User> getAllUser(String name,String surname,Integer nId);
    public  User findEmailAndPassword(String email,String password);
    public  User findEmail(String email);
    public User getById(int id);
    public boolean updateUser(User u);
    public boolean addUser(User u);
    public boolean removeUser(int id);
}
