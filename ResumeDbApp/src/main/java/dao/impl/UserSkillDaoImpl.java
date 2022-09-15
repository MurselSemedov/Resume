/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.inter.AbstractDAO;
import static dao.inter.AbstractDAO.connect;
import dao.inter.UserSkillDaoInter;
import entity.Skill;
import entity.User;
import entity.UserSkill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 99470
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    private static UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");
        User user = new User(userId);
        Skill skill = new Skill(skillId, skillName);
        return new UserSkill(null, user, skill, power);
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select u.*,us.skill_id,s.name as skill_name,us.power from user_skill us"
                    + " left join user u on u.id = us.user_id"
                    + " left join skill s on s.id = us.skill_id where u.id = " + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UserSkill us = getUserSkill(rs);
                result.add(us);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
