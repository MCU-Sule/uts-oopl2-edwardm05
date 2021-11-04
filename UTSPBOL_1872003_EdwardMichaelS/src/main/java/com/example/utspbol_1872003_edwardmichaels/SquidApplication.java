package com.example.utspbol_1872003_edwardmichaels;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//1872003 - Edward Michael S
public class SquidApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SquidApplication.class.getResource("SquidStage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Squid Game Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}