/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import static com.company.dao.inter.AbstractDAO.connect;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    @Override
    public boolean updateCountry(Country country) {
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement(""
                    + "update country set name =?,"
                    + "nationality=?"          
                    + "where id = ?");// prepareStatement--------Ignore SQL Enjection
            stmt.setString(1, country.getName());
            stmt.setString(2, country.getNationality());
            stmt.setInt(3, country.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeCountry(int id) {
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from country where id = " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Country getById(int countryId) {
        Country result = null;
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from country where id =" + countryId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getCountry(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addCountry(Country country) {
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into country(name,nationality) values(?,?)");
            stmt.setString(1, country.getName());
            stmt.setString(2, country.getNationality());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
