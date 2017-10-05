/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplp.controlcore.db;

import com.rplp.controlcore.entity.Classes;
import com.rplp.controlcore.entity.Student;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisdany pernillo
 * @version 0.0.1
 * Clase simple sin manejo de conexiones, se crea una nueva conexion cada vez
 * que se va a realizar una operacion con la base de datos
 */
public class DbManage {

    public DbManage() {

    }

    
    public List<Classes> getClasses(){
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Classes> clasesList = null;

        try{
            
            con = getConnection();
            
            try{
                ps = con.prepareStatement("SELECT * FROM UNIVERSITY.CLASS ");
                try{
                    rs = ps.executeQuery();
                    try{
                        clasesList = new ArrayList<>();
                        while(rs.next()){
                            Classes clase = new Classes();
                            clase.setIdClass(rs.getInt(1));
                            clase.setName(rs.getString(2));
                            clase.setSection(rs.getString(3));
                            clasesList.add(clase);
                        }
                    }finally{
                        rs.close();
                    }
                }finally{
                    ps.close();
                }
            }finally{
                con.close();
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }

        return clasesList;
    }


    private Student fillStudent(ResultSet rs){
        Student student = new Student();
        try{
            student.setIdStudent(rs.getInt("IDSTUDENT"));
            student.setName(rs.getString("NAME"));
            student.setCode(rs.getString("CODE"));
            student.setEmail(rs.getString("EMAIL"));
            student.setIdClass(rs.getInt("IDCLASS"));
            student.setSection(rs.getString("SECTION"));
        }catch(SQLException e){
            e.printStackTrace();
        }

        return student;
    }

    public List<Student> getStudentsById(String idClass, String section){

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> listStudent = null;

        try{
            con = getConnection();
            try{
                ps = con.prepareStatement(" SELECT * FROM UNIVERSITY.STUDENT WHERE IDCLASS = ?  AND SECTION = ? ");
                ps.setObject(1, idClass);
                ps.setObject(2,section);
                try{
                    rs = ps.executeQuery();
                    try{
                        listStudent = new ArrayList<>();
                        while(rs.next()){
                            Student student = fillStudent(rs);
                            listStudent.add(student);
                        }
                    }finally{
                        rs.close();
                    }
                }finally{
                    ps.close();
                }
            }finally {
                con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listStudent;

    }

    public List<Student> getStudentsList(){
    
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> studentList = null;
        try{
            
            con = getConnection();
         
            if(con == null){
                throw new SQLException("Connection is null");
            }
            
            try{
                ps = con.prepareStatement("SELECT * FROM UNIVERSITY.STUDENT");
                try{
                    rs = ps.executeQuery();
                    try{
                        studentList = new ArrayList<>();
                        while(rs.next()){
                            Student student = new Student();
                            student.setIdStudent(rs.getInt("IDSTUDENT"));
                            student.setName(rs.getString("NAME"));
                            student.setCode(rs.getString("CODE"));
                            student.setEmail(rs.getString("EMAIL"));
                            student.setIdClass(rs.getInt("IDCLASS"));
                            student.setSection(rs.getString("SECTION"));
                            studentList.add(student);
                        }
                    }finally{
                        rs.close();
                    }
                }finally{
                    ps.close();
                }
            }finally{
                con.close();
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
        return studentList;
    }

    /**
     * Para obtener conexion
     * se debe cerrar en el metodo
     * que lo utiliza
     * @return
     */
    private Connection getConnection(){
        
        System.out.println("Inicializando jdbc driver");

        try {
            Class.forName("com.mysql.jdbc.Driver");
          
        } catch (ClassNotFoundException e) {
           
            e.printStackTrace();
            return null;
        }

        Connection con = null;
        
        try {
            System.out.println("Creando la conexion");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UNIVERSITY", "luisdany", "Lsdany$");
            if (con != null) {
                System.out.println("conexion exitosa");
                return con;
            } else {
                System.out.println("Fallo la conexion");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("MySQL exception");
            e.printStackTrace();
            return null;
        }

    }

    public boolean saveStudentsList(List<Student> students, String idClass, String section){

        if(students != null){

            Connection con = null;
            PreparedStatement ps = null;
            String query = " INSERT INTO UNIVERSITY.STUDENT(IDSTUDENT, NAME, CODE, EMAIL, IDCLASS, SECTION) "+
                    " VALUES (? , ? , ? , ? , ? , ? ) ";

            try{
                con = getConnection();
                try{
                    for(Student s : students){

                        s.toString();
                        ps = con.prepareStatement(query);
                        ps.setInt(1,s.getIdStudent());
                        ps.setString(2,s.getName());
                        ps.setString(3,s.getCode());
                        ps.setString(4,s.getEmail());
                        ps.setInt(5, Integer.valueOf(idClass));
                        ps.setString(6, section);
                        try{
                            ps.executeUpdate();

                        }finally{
                            ps.close();
                            ps = null;
                        }
                    }
                }finally {
                    con.close();
                }
            }catch(Exception e){
                e.printStackTrace();
                return false;
            }



        }

        return true;
    }

    public boolean saveClass(String nameClass, String section){

        Connection con = null;
        PreparedStatement ps = null;

        try{
            con = getConnection();
            try{
                ps = con.prepareStatement("");
                try{
                    int row = ps.executeUpdate();
                    if(row > 0){
                        return true;
                    }else
                        return false;
                }finally {
                    ps.close();
                }
            }finally{
                con.close();
            }
        }catch(SQLException s){
            s.printStackTrace();
        }

        return false;
    }


    public static void main(String[] args) {

        System.out.println("Class for name");

        try {
            Class.forName("com.mysql.jdbc.Driver");
          
        } catch (ClassNotFoundException e) {
           
            e.printStackTrace();
            return;
        }

        try {
            // DriverManager: The basic service for managing a set of JDBC drivers.
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UNIVERSITY", "lsdany_db", "Lsdanydb");
            if (con != null) {
                System.out.println("conexion exitosa");
            } else {
                System.out.println("Fallo la conexion");
            }
        } catch (SQLException e) {
            System.out.println("MySQL exception");
            e.printStackTrace();
            return;
        }

    }

}
