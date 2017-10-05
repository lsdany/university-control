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
 * @version 0.1
 * */
public class Classes implements Serializable{
    
    private int idClass;
    private String name;
    private String section;

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Classes{" + "idClass=" + idClass + ", name=" + name + ", section=" + section + '}';
    }
    
    
}
