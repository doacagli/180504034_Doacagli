package com.example.nolurson;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene1Controller {
    @FXML
    TextField nameTextField;

    @FXML
    PasswordField passwortTextField;

    @FXML
    Label messageLabel;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Button logoutButton;


    private Scene scene;
    private Stage stage;
    private Parent root;

    public void login(ActionEvent event) throws IOException {

        String username = nameTextField.getText();
        String password = passwortTextField.getText();

        if(username.isEmpty() || password.isEmpty()){

            messageLabel.setText("Geben Sie bitte Benutzername und Passwort ein!");

        }else{
            if(Database.findUser(username, password)){
                if(Database.containAdmin(username)){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
                    root = loader.load();
                    stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    Scene2Controller scene2Controller =loader.getController();
                    scene2Controller.displayName(username);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2UserController.fxml"));
                    root = loader.load();
                    stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    Scene2UserController scene2UserController =loader.getController();
                    scene2UserController.displayName(username);
                    stage.setScene(scene);
                    stage.show();

                }


            }else{
                messageLabel.setText("Falsche Benutzername oder Passwort!");
            }

        }
    }

    public void logOut(ActionEvent event){
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        System.out.println("you successfully loggod out");
        stage.close();
    }
}
