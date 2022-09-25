/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.entity;

import java.sql.Date;

/**
 *
 * @author 99470
 */
public class User {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String profileDescription;
    private String address;
    private Date birthDate;
    private Country birthplace;
    private Country nationality;
    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }
    

    public User(int id, String name, String surname, String email, String phone,String profileDescription,String address, Date birthDate, Country birthPlace, Country nationality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.profileDescription = profileDescription;
        this.birthDate = birthDate;
        this.birthplace = birthPlace;
        this.nationality = nationality;
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Country getBirthPlace() {
        return birthplace;
    }

    public void setBirthPlace(Country birthPlace) {
        this.birthplace = birthPlace;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }
    

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", email=" + email + ", profileDescription=" + profileDescription + ", address=" + address + ", birthDate=" + birthDate + ", birthPlace=" + birthplace + ", nationality=" + nationality + '}';
    }

    

    

    
    
    
}
