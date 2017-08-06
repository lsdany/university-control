/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplp.controlweb.bean;

import com.rplp.controlcore.db.DbManage;
import com.rplp.controlcore.entity.Student;
import com.rplp.controlcore.read.ReadXLSX;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;



/**
 *
 * @author luisdany
 */
@ManagedBean
@SessionScoped
public class StudentBean {
    
    private String path = "/home/luisdany/Projects/FC-N-3190-022.xlsx" ;
    private List<Student> studentList;

    
    public StudentBean(){
        System.out.println("en bean-----------------------------");
    }
    
    public List<Student> getStudentList() {
        
        System.out.println("obteniendo lista de estudiantes");
        
        if(studentList == null){
            //mandar un aviso si se quiere cargar el xls
            DbManage manage = new DbManage();
            return manage.getStudentsList();
        }else
            return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    
    
    private List<Student> getStudentsFromXLS(){
        ReadXLSX xlsPage = new ReadXLSX();
        return xlsPage.getStudentsFromXLS(path);
        
    }
    
    private List<Student> getFooStudent(){
        
        System.out.println("Obteniendo estudiantes foo");
        
        List<Student> list = new ArrayList<>();
        

        
        
        System.out.println("tamaño de la lista "+list.size());
        
        return list;
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
}
