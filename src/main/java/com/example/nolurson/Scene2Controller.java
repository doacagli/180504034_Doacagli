package com.example.nolurson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene2Controller {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    Label nameLabel;
    @FXML
    private Button userButton;
    @FXML
    private Button klientButton;



    public void displayName(String username){

        nameLabel.setText("Willkommen " + username);
    }
    public void userThing(ActionEvent event) throws IOException {
        FXMLLoader a = new FXMLLoader(getClass().getResource("BenutzerController.fxml"));
        root = a.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void klientThing(ActionEvent event) throws IOException{
        FXMLLoader aa = new FXMLLoader(getClass().getResource("KlientController.fxml"));
        root = aa.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
