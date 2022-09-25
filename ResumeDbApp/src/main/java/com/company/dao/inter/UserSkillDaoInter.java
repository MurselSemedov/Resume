/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.UserSkill;
import java.util.List;

/**
 *
 * @author 99470
 */
public interface UserSkillDaoInter {
    public List<UserSkill> getAllSkillByUserId(int userId);
    public boolean removeUserSkill(int userSkill);
    public boolean addUserSkill(UserSkill userSkill);
    public boolean updateUserSkill(UserSkill userSkill);
    
}
