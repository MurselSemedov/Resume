/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import com.company.main.Context;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 99470
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {
    private BCrypt.Hasher crypt = BCrypt.withDefaults();
    private static User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDescription = rs.getString("profile_description");
        Date birthDate = rs.getDate("birthdate");
        int nationality_id = rs.getInt("nationality_id");
        int birthplace_id = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthplaceStr = rs.getString("birthplace");   
        String address  = rs.getString("address");
        Country nationality = new Country(nationality_id, null, nationalityStr);
        Country birthplace = new Country(birthplace_id, birthplaceStr, null);
        return new User(id, name, surname, email, phone,profileDescription,address, birthDate, birthplace, nationality);
    }
    private static User getUserSimple(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDescription = rs.getString("profile_description");
        Date birthDate = rs.getDate("birthdate");
        int nationality_id = rs.getInt("nationality_id");
        int birthplace_id = rs.getInt("birthplace_id");
        String address  = rs.getString("address");
        User u = new User(id, name, surname, email, phone,profileDescription,address, birthDate, null, null);
        u.setPassword(rs.getString("password"));
        System.out.println(u);
        return u;
    }
    
    @Override
    public List<User> getAllUser(String name,String surname,Integer nId) {
        List<User> result = new ArrayList<>();
        try ( Connection c = connect()) {
            String query = "select u.* ,c2.name as birthplace,c1.nationality "
                    + "from user u "
                    + " left join country c1 on c1.id = u.nationality_id "
                    + " left join country c2 on c2.id = u.birthplace_id where 1=1";
            if(name != null && !name.trim().isEmpty()){
                query += " and u.name=?";
            }
            if(surname != null && !surname.trim().isEmpty()){
                query += " and u.surname=?";
            }
            if(nId!=null){
                query += " and c1.id=?";
            }
            PreparedStatement stmt = c.prepareStatement(query);
            int count = 1;
            if(name!=null&&!name.trim().isEmpty()){
                stmt.setString(count,name);
                count++;
            }
            if(surname!=null&&!surname.trim().isEmpty()){
                stmt.setString(count,surname);
                count++;
            }
            if(nId!=null){
                stmt.setInt(count,nId);
            }
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    @Override
    public  User findEmailAndPassword(String email,String password){
        User u = null;
        try(Connection c = connect()){
            PreparedStatement  ps = c.prepareStatement("select * from user where email=? and password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                u = getUserSimple(rs);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return u ;
    }
    public  User findEmail(String email){
        User u = null;
        try(Connection c = connect()){
            PreparedStatement  ps = c.prepareStatement("select * from user where email=?");
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                u = getUserSimple(rs);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return u ;
    }

    @Override
    public boolean updateUser(User u) {
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement(""
                    + "update user set name =?,"
                    + "surname=?,"
                    + "email=?,"
                    + "phone=?,"
                    + "profile_description=?,"
                    + "address=?,"
                    + "birthplace_id=?,"
                    + "nationality_id=? "
                    + "where id = ?");// prepareStatement--------Ignore SQL Enjection
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            stmt.setString(5, u.getProfileDescription());
            stmt.setString(6, u.getAddress());
            stmt.setInt(7,u.getBirthPlace().getId());
            stmt.setInt(8, u.getNationality().getId());
            stmt.setInt(9, u.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id = " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select u.* ,c2.name as birthplace,c1.nationality"
                    + " from user u"
                    + " left join country c1 on c1.id = u.nationality_id"
                    + " left join country c2 on c2.id = u.birthplace_id where u.id =" + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u) {
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into user(name,surname,email,password,phone) values(?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, crypt.hashToString(4,u.getPassword().toCharArray()));
            stmt.setString(5, u.getPhone());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
