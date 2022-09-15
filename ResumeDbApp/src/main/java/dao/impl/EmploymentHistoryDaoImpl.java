/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.inter.AbstractDAO;
import entity.EmploymentHistory;
import entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.inter.EmploymentHistoryDaoInter;

/**
 *
 * @author 99470
 */
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

    private static EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception{
        int userId = rs.getInt("user_id");
        String header = rs.getString("header");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        String jobDescription = rs.getString("job_description");
        User user = new User(userId);
        return new EmploymentHistory(null, header, beginDate, endDate, jobDescription, user);

    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {

        List<EmploymentHistory> result = new ArrayList<>();
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from employment_history where user_id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                EmploymentHistory eh = getEmploymentHistory(rs);
                result.add(eh);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

}
