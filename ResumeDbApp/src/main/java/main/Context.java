/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.impl.UserDaoImpl;
import dao.inter.UserDaoInter;

/**
 *
 * @author 99470
 */
public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
}
