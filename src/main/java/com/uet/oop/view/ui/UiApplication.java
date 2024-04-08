package com.uet.oop.view.ui;

import com.uet.oop.view.OopGameApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UiApplication extends Application implements OopGameApplication {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("UET OOP Games");

        Parent root = FXMLLoader.load(getClass().getResource("/com/uet/oop/DictionaryView.fxml"));
        Scene scene = new Scene(root, 1200, 800);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void runApplication() {
        launch();
    }

}
