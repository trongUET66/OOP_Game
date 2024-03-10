package com.uet.oop.dao;

import com.uet.oop.data.database.DatabaseConnection;
import com.uet.oop.model.Dictionary;
import com.uet.oop.model.Word;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DictionaryDAO implements DAOInterface<Dictionary>{

    public static DictionaryDAO getInstance(){
        return new DictionaryDAO();
    }
    @Override
    public int insert(Dictionary dictionary) {
        int result = 0;
        try {
            DatabaseConnection connectionNow = new DatabaseConnection();
            Connection connectDB = connectionNow.getDBConnection();
            Statement statement= connectDB.createStatement();
            String sql = "INSERT INTO dictionary (id, target, definition)" + " VALUES ('"+dictionary.getId()+"' , '"
                    +dictionary.getTarget()+"' , '"+ dictionary.getDefinition()+"')";

            result = statement.executeUpdate(sql);

            System.out.println("Ban da thuc thi: "+sql );
            System.out.println("Co: "+result );
            connectDB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int update(Dictionary dictionary) {
        int result = 0;
        try {
            DatabaseConnection connectionNow = new DatabaseConnection();
            Connection connectDB = connectionNow.getDBConnection();
            Statement statement= connectDB.createStatement();
            String sql = "UPDATE dictionary " + " SET "
                        + " target='"+dictionary.getTarget()+"'"
                        + ", definition='"+dictionary.getDefinition()+"'"
                        + " WHERE target='"+dictionary.getTarget()+"'";

            result = statement.executeUpdate(sql);

            System.out.println("Ban da thuc thi: "+sql );
            System.out.println("Co: "+result );
            connectDB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int delete(Dictionary dictionary) {
        int result = 0;
        try {
            DatabaseConnection connectionNow = new DatabaseConnection();
            Connection connectDB = connectionNow.getDBConnection();
            Statement statement= connectDB.createStatement();
            String sql = "DELETE FROM dictionary "
                    + " WHERE target='"+dictionary.getTarget()+"'";

            result = statement.executeUpdate(sql);

            System.out.println("Ban da thuc thi: "+sql );
            System.out.println("Co: "+result );
            connectDB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public ArrayList<Dictionary> selectAll() {
        ArrayList<Dictionary> dictionaries = new ArrayList<Dictionary>();
        try {
            DatabaseConnection connectionNow = new DatabaseConnection();
            Connection connectDB = connectionNow.getDBConnection();
            Statement statement= connectDB.createStatement();
            String sql = "SELECT * FROM dictionary";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String target = resultSet.getString("target");
                String definition = resultSet.getString("definition");

                Dictionary dictionary = new Dictionary(id,target,definition);
                dictionaries.add(dictionary);
            }
            connectDB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dictionaries;
    }

    @Override
    public Dictionary selectById(Dictionary dictionary) {
        Dictionary dictionaries = null;
        try {
            DatabaseConnection connectionNow = new DatabaseConnection();
            Connection connectDB = connectionNow.getDBConnection();
            Statement statement= connectDB.createStatement();
            String sql = "SELECT * FROM dictionary WHERE id='"+dictionary.getId()+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String target = resultSet.getString("target");
                String definition = resultSet.getString("definition");

                dictionaries = new Dictionary(id,target,definition);
            }
            connectDB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dictionaries;
    }

    @Override
    public ArrayList<Dictionary> selectByCondition(String condition) {
        ArrayList<Dictionary> dictionaries = new ArrayList<Dictionary>();
        try {
            DatabaseConnection connectionNow = new DatabaseConnection();
            Connection connectDB = connectionNow.getDBConnection();
            Statement statement= connectDB.createStatement();
            String sql = "SELECT * FROM dictionary WHERE " + condition;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String target = resultSet.getString("target");
                String definition = resultSet.getString("definition");

                Dictionary dictionary = new Dictionary(id,target,definition);
                dictionaries.add(dictionary);
            }
            connectDB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dictionaries;
    }
}
