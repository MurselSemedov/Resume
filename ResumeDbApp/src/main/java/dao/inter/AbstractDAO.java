/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author 99470
 */

/*

      DAO----->Data Access Object

*/
public abstract class AbstractDAO {
    public static Connection connect() throws Exception{
        String url = "jdbc:mysql://localhost:3306/resume";
        String user = "root";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }
}
