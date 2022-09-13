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
public abstract class AbstractDAO {
    public static Connection connect() throws Exception{
        String url = "jdbc:mysql://localhost:3306/resume";
        String user = "root";
        String password = "0708832206mM";
        return DriverManager.getConnection(url, user, password);
    }
}
