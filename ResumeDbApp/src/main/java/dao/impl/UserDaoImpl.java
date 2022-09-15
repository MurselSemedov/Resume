/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import entity.Country;
import entity.User;
import dao.inter.AbstractDAO;
import dao.inter.UserDaoInter;
import entity.Skill;
import entity.UserSkill;
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

    private static User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        Date birthDate = rs.getDate("birthdate");
        int nationality_id = rs.getInt("nationality_id");
        int birthplace_id = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthplaceStr = rs.getString("birthplace");
        Country nationality = new Country(nationality_id, null, nationalityStr);
        Country birthplace = new Country(birthplace_id, birthplaceStr, null);
        return new User(id, name, surname, email, phone, birthDate, birthplace, nationality);
    }

    
    @Override
    public List<User> getAllUser() {
        List<User> result = new ArrayList<>();
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select u.* ,c2.name as birthplace,c1.nationality "
                    + "from user u "
                    + "left join country c1 on c1.id = u.nationality_id "
                    + "left join country c2 on c2.id = u.birthplace_id");
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
    public boolean updateUser(User u) {
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement(""
                    + "update user set name =?,"
                    + "surname=?,"
                    + "email=?,"
                    + "phone=? "
                    + "where id = ?");// prepareStatement--------Ignore SQL Enjection
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            stmt.setInt(5, u.getId());
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
                    + "from user u"
                    + "left join country c1 on c1.id = u.nationality_id"
                    + "left join country c2 on c2.id = u.birthplace_id where u.id =" + userId);
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
            PreparedStatement stmt = c.prepareStatement("insert into user(name,surname,email,phone) values(?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    

}
