/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplp.controlcore.entity;

import java.io.Serializable;

/**
 *
 * @author luisdany
 */
public class Student implements Serializable{

//     `IDSTUDENT` INT NOT NULL auto_increment,
//  `NAME` VARCHAR(100) NOT NULL,
//  `CODE` VARCHAR(25) NOT NULL,
//  `EMAIL` VARCHAR(100) NULL,
//  `IDCLASS` INT NOT NULL,
//            `SECTION` VARCHAR(2) NOT NULL,
//    PRIMARY KEY (`IDSTUDENT`),

    private int idStudent;
    private String name;
    private String code;
    private String email;
    private int idClass;
    private String section;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
