/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplp.controlcore.db;

import com.rplp.controlcore.entity.Classes;
import com.rplp.controlcore.entity.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author luisdany pernillo
 * @version 0.0.1
 * Clase simple sin manejo de conexiones, se crea una nueva conexion cada vez
 * que se va a realizar una operacion con la base de datos
 */
public class DbManage {

    static Connection con = null;
    static PreparedStatement ps = null;

    public DbManage() {

    }

    
    public List<Classes> getClasses(){
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            con = null;
            
            try{
                ps = con.prepareStatement(null);
                try{
                    rs = ps.executeQuery();
                    try{
                        while(rs.next()){
                            
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
        
        
        
        return null;
    }
    
    public List<Student> getStudentsDB(){
    
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            con = getConnection();
         
            if(con == null){
                throw new SQLException("Conection is null");
            }
            
            try{
                ps = con.prepareStatement(null);
                try{
                    rs = ps.executeQuery();
                    try{
                        while(rs.next()){
                            
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
        
        
        return null;
    }
    
    
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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UNIVERSITY", "lsdany_db", "Lsdanydb");
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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UNIVERSITY", "lsdany_db", "Lsdanydb");
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
