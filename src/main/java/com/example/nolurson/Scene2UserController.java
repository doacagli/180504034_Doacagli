package com.example.nolurson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Scene2UserController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button logout;
    @FXML
    private Label nameLabel;

    public void logOut(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        System.out.println("you successfully loggod out");
        stage.close();
    }
    public void displayName(String username){

        nameLabel.setText("Willkommen " + username);
    }
}
