package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DictionaryController implements Initializable{


    @FXML
    private Button searchButton;

    @FXML
    private TableColumn<DictionaryModel, String> wordList;

    @FXML
    private TableView<DictionaryModel> dictionaryTableView;

    @FXML
    private TextField keywordTextField;

    ObservableList<DictionaryModel> dictionaryModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource){
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getDBConnection();

        String dictionaryViewQuery = "SELECT target FROM dictionary";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(dictionaryViewQuery);

            while(queryOutput.next()){
                String queryTarget = queryOutput.getString("target");

                dictionaryModelObservableList.add(new DictionaryModel(queryTarget));
            }

            wordList.setCellValueFactory(new PropertyValueFactory<>("target"));

            dictionaryTableView.setItems(dictionaryModelObservableList);

            FilteredList<DictionaryModel> filteredData = new FilteredList<>(dictionaryModelObservableList, b -> true);

            keywordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(dictionaryModel -> {

                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String searchKeyWord = newValue.toLowerCase();

                    if(dictionaryModel.getTarget().toLowerCase().indexOf(searchKeyWord) > -1){
                        return true;
                    } else return false;

                });
            });

            SortedList<DictionaryModel> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(dictionaryTableView.comparatorProperty());

            dictionaryTableView.setItems(sortedData);

        } catch (SQLException e){
            Logger.getLogger(DictionaryController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }


}
