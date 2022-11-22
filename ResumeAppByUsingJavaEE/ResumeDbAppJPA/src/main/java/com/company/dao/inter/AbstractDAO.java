/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 99470
 */

/*

      DAO----->Data Access Object

*/
public abstract class AbstractDAO {
    public static Connection connect() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String user = "root";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }
    
    private EntityManagerFactory emf = null;
    
    public EntityManager em(){
        if(emf==null){
            emf = Persistence.createEntityManagerFactory("resumeappPU");
        }
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
    public void close(){
        emf.close();
    }
}
