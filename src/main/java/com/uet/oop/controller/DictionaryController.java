package com.uet.oop.controller;

import com.uet.oop.dao.DictionaryDAO;
import com.uet.oop.data.database.DatabaseConnection;
import com.uet.oop.model.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DictionaryController implements Initializable{


    private DictionaryDAO management = new DictionaryDAO();

    @FXML
    public ImageView imageSearch;

    @FXML
    private Image searchButton;

    @FXML
    private TableColumn<Word, String> wordList;

    @FXML
    private TableView<Word> dictionaryTableView;

    @FXML
    private TextField keywordTextField;

    ObservableList<Word> observableWords = FXCollections.observableArrayList();

    @Override
    public void initialize(URL var1, ResourceBundle var2){

        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getDBConnection();

        String dictionaryViewQuery = "SELECT target FROM dictionary";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(dictionaryViewQuery);

            while(queryOutput.next()){
                String queryTarget = queryOutput.getString("target");

                observableWords.add(new Word(queryTarget, ""));
            }

            wordList.setCellValueFactory(new PropertyValueFactory<>("target"));

            dictionaryTableView.setItems(observableWords);

            FilteredList<Word> filteredData = new FilteredList<>(observableWords, b -> true);

            keywordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(dictionaryModel -> {

                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyWord = newValue.toLowerCase();

                    return dictionaryModel.getTarget().toLowerCase().contains(searchKeyWord);

                });
            });

            SortedList<Word> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(dictionaryTableView.comparatorProperty());

            dictionaryTableView.setItems(sortedData);
            connectionNow.closeConnection(connectDB);

        } catch (SQLException e){
            Logger.getLogger(DictionaryController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }


}
