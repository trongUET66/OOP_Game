package org.example.demo;

import java.sql.*;

public class DatabaseConnection {
    public Connection databaseLink;
    public Connection getDBConnection(){
        String databaseName = "dictionary";
        String databaseUser = "root";
        String databasePassword = "284838";
        String url = "jdbc:mysql://localhost/" + databaseName;


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e){
            e.printStackTrace();
        }

        return databaseLink;
    }
}
