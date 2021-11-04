module com.example.utspbol_1872003_edwardmichaels {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.utspbol_1872003_edwardmichaels to javafx.fxml;
    exports com.example.utspbol_1872003_edwardmichaels;
    exports com.example.utspbol_1872003_edwardmichaels.Controller;
    opens com.example.utspbol_1872003_edwardmichaels.Controller to javafx.fxml;
}