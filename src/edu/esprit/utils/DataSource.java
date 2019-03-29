/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author WIKI
 */
public class DataSource {
    String myDriver = "com.mysql.jdbc.Driver";

    
    private static volatile Connection connection = null;
    private static volatile DataSource instance = null;
    
    private DataSource() {    
  	  if (instance != null) {
  	    throw new RuntimeException("You can create only  one instance");
  	  }
    }

    public Connection getConnection() {   
    	 if (connection == null) {
       	    synchronized(DataSource.class) {
      	     if (connection == null) {
      	    	try {
      	    	  
      	    	   String url = "jdbc:mysql://localhost:3306/charity?autoReconnect=true&useSSL=false";
      	    	   String login = "root";
      	    	   String password = "";
      	    	   
         	       System.out.println("not null");
         	       connection = DriverManager.getConnection(url, login, password);
         	       System.out.println("Connected Successfully ...");
         	      } catch (SQLException e) {
         	       e.printStackTrace();
         	      }
         	     }      	     
      	       }
      	    }
     	return connection;
}
    	
    
    public static  DataSource getInstance() {      
    	 if (instance == null) {
      	    synchronized(DataSource.class) {
     	     if (instance == null) {
     	      instance = new DataSource();
     	     }
     	    }
     	  }
        return instance ;      
    }
}