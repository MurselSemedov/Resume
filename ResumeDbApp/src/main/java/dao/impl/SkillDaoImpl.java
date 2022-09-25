/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.inter.AbstractDAO;
import static dao.inter.AbstractDAO.connect;
import dao.inter.SkillDaoInter;
import entity.Skill;
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
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    private Skill getSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return new Skill(id, name);
    }

    @Override
    public List<Skill> getAllSkill() {
        List<Skill> result = new ArrayList<>();
        try (Connection c = connect()) {
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

    @Override
    public boolean updateSkill(Skill skill) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update skill set name =? where id = ?");
            stmt.setString(1, skill.getName());
            stmt.setInt(2, skill.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeSkill(int skillId) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from skill where id = " + skillId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Skill getById(int skillId) {
        Skill result = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from skill where id =" + skillId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getSkill(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addSkill(Skill skill) {
        boolean b;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into skill(name) values(?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, skill.getName());
            b = stmt.execute();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                skill.setId(generatedKeys.getInt(1));
            }
            return b;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
