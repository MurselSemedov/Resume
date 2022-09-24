/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.inter.SkillDaoInter;

import javax.swing.*;


public class Main {


    public static void main(String[] args) throws Exception {
        //UserDaoInter userDao = Context.instanceUserDao();       //thightly coupling
        SkillDaoInter dao = Context.instanceSkillDao();
        System.out.println(dao.getAllSkill());
    }
}
