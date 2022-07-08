package com.example.nolurson;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("firstPage.fxml"));
            Scene firstpage = new Scene(fxmlLoader.load());
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("AnwaltSYS");
            stage.setScene(firstpage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Database database = new Database();
        database.connect();
        Database.listBenutzer();
    }
        public static void main (String[]args){

            launch();
        }



}

