package com.uet.oop.data.database;

import java.sql.*;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getDBConnection() {
        String databaseName = "dictionary";
        String username = "root";
        String password = "Tr717503";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, username, password);
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

    private static DatabaseConnection connection = null;

    public static DatabaseConnection getInstance() {
        if (connection == null) {
            connection = new DatabaseConnection();
        }
        return connection;
    }

}
