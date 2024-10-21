package com.joules;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private String url = "jdbc:mysql://localhost:3306/joules_app_db";
    private String user = "joules";
    private String password = "galj#05839";
    public Connection connection;

    public DatabaseConnection(){
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected Successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
