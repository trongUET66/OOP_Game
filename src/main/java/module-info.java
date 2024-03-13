module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;
    requires freetts;

    opens com.uet.oop to javafx.fxml;
    exports com.uet.oop;
    exports com.uet.oop.model;
    opens com.uet.oop.model to javafx.fxml;
    exports com.uet.oop.controller;
    opens com.uet.oop.controller to javafx.fxml;
    exports com.uet.oop.view;
    opens com.uet.oop.view to javafx.fxml;
    exports com.uet.oop.view.ui;
    opens com.uet.oop.view.ui to javafx.fxml;
    exports com.uet.oop.view.commandline;
    opens com.uet.oop.view.commandline to javafx.fxml;
}