/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplp.controlweb.bean;

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
//            return getFooStudent();//getStudentsFromXLS();
            return getStudentsFromXLS();
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
        
        Student s1 = new Student();
        s1.setEmail("student1@gmail.com");
        s1.setId(1);
        s1.setIdCard("3190-13-12063");
        s1.setName("Luis");
        list.add(s1);
        
        Student s2 = new Student();
        s2.setEmail("student1@gmail.com");
        s2.setId(2);
        s2.setIdCard("3190-13-12063");
        s2.setName("Dany");
        list.add(s2);
        
        Student s3 = new Student();
        s3.setEmail("student1@gmail.com");
        s3.setId(3);
        s3.setIdCard("3190-13-12063");
        s3.setName("Israel");
        list.add(s3);
        
        Student s4 = new Student();
        s4.setEmail("student1@gmail.com");
        s4.setId(4);
        s4.setIdCard("3190-13-12063");
        s4.setName("Luisdany");
        list.add(s4);
        
        
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
