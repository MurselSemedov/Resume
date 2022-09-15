/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.inter.AbstractDAO;
import static dao.inter.AbstractDAO.connect;
import dao.inter.CountryDaoInter;
import entity.Country;
import entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 99470
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter{
    private Country getCountry(ResultSet rs) throws Exception{
       int id = rs.getInt("id");
       String name = rs.getString("name");
       String nationality = rs.getString("nationality");
       return new Country(id, name, nationality);
    }
    @Override
    public List<Country> getAllCountry(){
        List<Country> result = new ArrayList<>();
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from country");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Country u = getCountry(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
}
