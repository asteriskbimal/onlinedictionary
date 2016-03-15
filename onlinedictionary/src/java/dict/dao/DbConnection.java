/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dict.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
/**
 *
 * @author 984910
 */
public class DbConnection {
     
    Connection conn;
    private final String DBNAME="entries";
    private final String USERNAME="root";
    private final String PASSWORD="";
    private final String CONNECTIONSTRING="jdbc:mysql://localhost:3306/"+DBNAME;
    
   private static DbConnection instance = null;
   protected DbConnection(){
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(CONNECTIONSTRING,USERNAME,PASSWORD);
        } catch (SQLException ex) {
            
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public static DbConnection getInstance() {
      if(instance == null) {
         instance = new DbConnection();
      }
      return instance;
   }
   
   public Connection getConnection(){
       return conn;
   
   } 
}
