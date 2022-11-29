/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testapplication.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author theodoulosc
 * This is a class where Application connects to MySQLDB
 */
public class DBConnection {
    
    public Connection getConnection() throws SQLException {
        
        Connection con = null;
        final String PARAM_DRIVER="com.mysql.jdbc.Driver";
        final String PARAM_URL="jdbc:mysql://localhost:3306/sql_library_system";
        final String PARAM_USER="root";
        final String PARAM_PASSWORD="Aloma_23u";
        
        try {
            Class.forName(PARAM_DRIVER);
            con = DriverManager.getConnection(PARAM_URL, PARAM_USER, PARAM_PASSWORD);
            System.out.println("Connected to the db");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("No connected to the db");
        }
        return con;  
    }
}
