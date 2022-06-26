module com.example.nolurson {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.nolurson to javafx.fxml;
    exports com.example.nolurson;
}