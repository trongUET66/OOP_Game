module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens org.example.demo to javafx.fxml;
    exports org.example.demo;
}