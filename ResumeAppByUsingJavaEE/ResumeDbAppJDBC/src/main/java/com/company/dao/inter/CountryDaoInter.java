/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.Country;
import java.util.List;

/**
 *
 * @author 99470
 */
public interface CountryDaoInter {
    public List<Country> getAllCountry();
    public boolean addCountry(Country country);
    public boolean updateCountry(Country country);
    public Country getById(int countryId);
    public boolean removeCountry(int countryId);
}
