package com.uet.oop.data.database;

import java.sql.*;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getDBConnection() {
        String databaseName = "dictionary";
        String databaseUser = "root";
        String databasePassword = "Tr717503";
        String url = "jdbc:mysql://localhost/" + databaseName;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Class.forName("com.mysql.jdbc.Driver");

            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }

    public static void closeConnection(Connection connection) {
        try {
            if(connection != null) {
                connection.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
