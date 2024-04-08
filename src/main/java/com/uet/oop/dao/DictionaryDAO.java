package com.uet.oop.dao;

import com.uet.oop.data.database.DatabaseConnection;
import com.uet.oop.model.Word;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DictionaryDAO implements DAOInterface<Word> {

    private final DatabaseConnection connection = DatabaseConnection.getInstance();

    public DictionaryDAO() {
        connection.getDBConnection();
    }

    @Override
    public int insert(Word word) {
        int result;
        try {
            Connection connectDB = connection.getDBConnection();
            Statement statement = connectDB.createStatement();

            String sql = "INSERT INTO words (id, target, explain) VALUES ('%d' , '%s' , '%s')"
                    .formatted(word.getId(), word.getTarget(), word.getExplain());

            result = statement.executeUpdate(sql);

            System.out.println("Executed statement: " + sql);
            System.out.println("Result: " + result);

            connectDB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int update(Word word) {
        int result;
        try {
            Connection connectDB = connection.getDBConnection();
            Statement statement = connectDB.createStatement();
            String sql = "UPDATE words SET explain='%s' WHERE target='%s'"
                    .formatted(word.getExplain(), word.getTarget());

            result = statement.executeUpdate(sql);

            System.out.println("Executed statement: " + sql);
            System.out.println("Result: " + result);

            connectDB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int delete(Word word) {
        int result;
        try {
            Connection connectDB = connection.getDBConnection();
            Statement statement = connectDB.createStatement();
            String sql = "DELETE FROM words WHERE target='%s'".formatted(word.getTarget());

            result = statement.executeUpdate(sql);

            System.out.println("Executed statement: " + sql);
            System.out.println("Result: " + result);

            connectDB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public List<Word> selectAll() {
        ArrayList<Word> dictionaries = new ArrayList<>();
        try {
            Connection connectDB = connection.getDBConnection();
            Statement statement = connectDB.createStatement();

            String sql = "SELECT * FROM words order by target ASC";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String target = resultSet.getString("target");
                String explain = resultSet.getString("explain");

                Word word = new Word(id, target, explain);
                dictionaries.add(word);
            }

            connectDB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dictionaries;
    }

    @Override
    public Word findById(int id) {
        Word word = null;
        try {
            Connection connectDB = connection.getDBConnection();
            Statement statement = connectDB.createStatement();

            String sql = "SELECT * FROM words WHERE id='%d'".formatted(id);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String target = resultSet.getString("target");
                String explain = resultSet.getString("explain");
                word = new Word(id, target, explain);
            }

            connectDB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return word;
    }

    @Override
    public Word findByTarget(String target) {
        Word word = null;
        try {
            Connection connectDB = connection.getDBConnection();
            Statement statement = connectDB.createStatement();

            String sql = "SELECT * FROM words WHERE target='%s'".formatted(target);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long wordId = resultSet.getLong("id");
                String wordTarget = resultSet.getString("target");
                String wordExplain = resultSet.getString("explain");
                word = new Word(wordId, wordTarget, wordExplain);
            }

            connectDB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return word;
    }

    @Override
    public List<Word> selectByCondition(String condition) {
        ArrayList<Word> words = new ArrayList<>();
        try {
            Connection connectDB = connection.getDBConnection();
            Statement statement = connectDB.createStatement();

            String sql = "SELECT * FROM words WHERE %s ORDER BY target ASC".formatted(condition);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String target = resultSet.getString("target");
                String explain = resultSet.getString("explain");

                Word word = new Word(id, target, explain);
                words.add(word);
            }

            System.out.println("Executed statement: " + sql);
            System.out.println("Result size: " + words.size());

            connectDB.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return words;
    }

    private static DictionaryDAO dictionaryDAO = null;

    public static DictionaryDAO getInstance() {
        if (dictionaryDAO == null) {
            dictionaryDAO = new DictionaryDAO();
        }
        return dictionaryDAO;
    }

}
