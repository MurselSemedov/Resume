/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import static com.company.dao.inter.AbstractDAO.connect;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import java.sql.Statement;

/**
 *
 * @author 99470
 */
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

    private static EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {
        int empHistoryId = rs.getInt("id");
        int userId = rs.getInt("user_id");
        String header = rs.getString("header");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        String jobDescription = rs.getString("job_description");
        User user = new User(userId);
//        return new EmploymentHistory(empHistoryId, header, beginDate, endDate, jobDescription, user);
return  null;
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {

        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection c = connect()) {
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

    @Override
    public boolean addEmploymentHistory(EmploymentHistory empHistory) {
        boolean b;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into employment_history(header,begin_date,end_date,job_description,user_id) values(?,?,?,?,?)");
            stmt.setString(1, empHistory.getHeader());
//            stmt.setDate(2, empHistory.getBeginDate());
//            stmt.setDate(3, empHistory.getEndDate());
            stmt.setString(4, empHistory.getJobDescription());
//            stmt.setInt(5, empHistory.getUser().getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory empHistory) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update employment_history set header =?,begin_date=?,end_date=?,job_description=?,user_id=? where id = ?");
            stmt.setString(1, empHistory.getHeader());
//            stmt.setDate(2, empHistory.getBeginDate());
//            stmt.setDate(3, empHistory.getEndDate());
            stmt.setString(4, empHistory.getJobDescription());
//            stmt.setInt(5, empHistory.getUser().getId());
            stmt.setInt(6, empHistory.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeEmploymentHistory(int empHistoryId) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from employment_history where id = " + empHistoryId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
