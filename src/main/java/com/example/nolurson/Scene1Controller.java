package com.example.nolurson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller {
    @FXML
    TextField nameTextField;

    @FXML
    TextField passwortTextField;

    @FXML
    Label messageLabel;


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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
                root = loader.load();
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                Scene2Controller scene2Controller =loader.getController();
                scene2Controller.displayName(username);

                stage.setScene(scene);
                stage.show();
            }else{
                messageLabel.setText("Falsche Benutzername oder Passwort!");
            }


        }
    }
}
