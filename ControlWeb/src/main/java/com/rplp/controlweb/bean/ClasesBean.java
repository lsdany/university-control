/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplp.controlweb.bean;

import com.rplp.controlcore.db.DbManage;
import com.rplp.controlcore.entity.Classes;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author luisdany
 */

@ManagedBean
@SessionScoped
public class ClasesBean {

    private List<Classes> classesList;

    public List<Classes> getClassesList() {

        if(classesList == null){
            DbManage manage = new DbManage();
            return manage.getClasses();
        }

        return classesList;
    }


    public String goStudents(){
        System.out.println("in goStudents method");
        return "students.xhtml";
    }

    public void setClassesList(List<Classes> classesList) {
        this.classesList = classesList;
    }
    
    
    
}
