/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplp.passwordcontrol.bean;

import com.rplp.passwordcontrol.entity.Credential;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author luisdany pernillo
 */
@ManagedBean
@SessionScoped
public class PasswordBean {
    
    List<Credential> credentialList; 
                                
    
    public PasswordBean(){
        System.out.println("Executing PasswordBean");
    }

    public List<Credential> getCredentialList() {
        return credentialList;
    }

    public void setCredentialList(List<Credential> credentialList) {
        this.credentialList = credentialList;
    }
    
    
    
}
