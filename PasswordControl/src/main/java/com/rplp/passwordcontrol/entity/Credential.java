/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplp.passwordcontrol.entity;

import java.util.Date;

/**
 *
 * @author luisdany
 */
public class Credential {
   
  
    private String user;
    private String password;
    private Date addedDate;
    private Date validDate;
    private CredentialType type;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public CredentialType getType() {
        return type;
    }

    public void setType(CredentialType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Credential{" + "user=" + user + ", password=" + password + ", addedDate=" + addedDate + ", validDate=" + validDate + ", type=" + type + '}';
    }
    
    
    
    
    
}
