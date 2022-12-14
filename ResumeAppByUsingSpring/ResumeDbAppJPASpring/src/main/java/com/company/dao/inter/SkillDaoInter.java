/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.Skill;

import java.util.List;

/**
 *
 * @author 99470
 */
public interface SkillDaoInter {
    public List<Skill> getAllSkill();
    public boolean addSkill(Skill skill);
    public boolean updateSkill(Skill skill);
    public boolean removeSkill(int skillId);
    public Skill getById(int skillId);
}
