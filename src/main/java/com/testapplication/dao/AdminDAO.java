/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testapplication.dao;

import com.testapplication.db.DBConnection;
import com.testapplication.model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author theodoulosc
 */
public class AdminDAO {
    
    public ArrayList<Admin> getAllAdmins() throws SQLException {
        
        
        ArrayList<Admin> list = new ArrayList<Admin>();
        Admin admin;
        
        Connection con = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;
        DBConnection connection = new DBConnection();
        
        try {
            con = connection.getConnection();
            String sql = "SELECT * FROM admin";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String firstName = rs.getString(4);
                String lastName =rs.getString(5);
                
                admin = new Admin(id,username,password,firstName,lastName);
                list.add(admin);
            }            
        } catch(SQLException e){
            e.printStackTrace();
            System.out.print("Cant fetch all the data");
        } finally {
            con.close();
            ps.close();
            rs.close();
            System.out.println("ResultSet has been closed");
            System.out.println("Connection to db has been closed");
            System.out.println("PreparedStatement has been closed");
        }
        return list;
    }
}