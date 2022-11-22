/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.EmploymentHistory;
import java.util.List;

/**
 *
 * @author 99470
 */
public interface EmploymentHistoryDaoInter {
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);
    public boolean addEmploymentHistory(EmploymentHistory empHistory);
    public boolean updateEmploymentHistory(EmploymentHistory empHistory);
    public boolean removeEmploymentHistory(int empHistoryId);
    
}
