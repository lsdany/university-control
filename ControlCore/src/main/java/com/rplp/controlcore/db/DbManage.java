/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplp.controlcore.db;

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
 */
public class DbManage {

    static Connection crunchifyConn = null;
    static PreparedStatement crunchifyPrepareStat = null;

    public DbManage() {

    }

    private static void log(String text){
        System.out.println(text);
    }
    
    
    public List<Student> getStudentsDB(){
    
        
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
    
    
    public static void main(String[] args) {

        System.out.println("Manage");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            log("Congrats - Seems your MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            log("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
            e.printStackTrace();
            return;
        }

        try {
            // DriverManager: The basic service for managing a set of JDBC drivers.
            crunchifyConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "lsdany_db", "Lsdanydb");
            if (crunchifyConn != null) {
                log("Connection Successful! Enjoy. Now it's time to push data");
            } else {
                log("Failed to make connection!");
            }
        } catch (SQLException e) {
            log("MySQL Connection Failed!");
            e.printStackTrace();
            return;
        }

    }

}
