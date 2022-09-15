/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.inter.AbstractDAO;
import static dao.inter.AbstractDAO.connect;
import dao.inter.SkillDaoInter;
import entity.Country;
import entity.Skill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 99470
 */
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter{

   private Skill getSkill(ResultSet rs) throws Exception{
       int id = rs.getInt("id");
       String name = rs.getString("name");
       return new Skill(id, name);
    }
    @Override
    public List<Skill> getAllSkill(){
        List<Skill> result = new ArrayList<>();
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from skill");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Skill s = getSkill(rs);
                result.add(s);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
}
