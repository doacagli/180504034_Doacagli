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
import java.util.EventObject;

public class Scene2UserController {
    private String c;
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
        c = username;
    }
    public void klientThing(ActionEvent event) throws IOException {
        FXMLLoader aa = new FXMLLoader(getClass().getResource("KlientController.fxml"));
        root = aa.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void rechtThing(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RechtsfallController.fxml"));
        Parent bb = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(bb);
        stage.setScene(scene);
        stage.show();
    }

    public void popUp(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BenutzerUser.fxml"));
        //Parent root = loader.load();
        root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        BenutzerUserController benutzerUserController = loader.getController();
        benutzerUserController.getUsername(c);
        stage.setScene(scene);
        stage.show();
    }

}
