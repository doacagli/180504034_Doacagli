package com.example.nolurson;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController {
    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private Button logoutButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passwortTextField;

    @FXML
    private Button registerButton;

    public void initialize(URL location, ResourceBundle resources){
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!nameTextField.getText().trim().isEmpty() && !passwortTextField.getText().trim().isEmpty()){

                }else{
                    System.out.println("Bitte füllen Sie alle Informationen aus!");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Bitte füllen Sie alle Informationen aus zum Registierung! ");
                    alert.show();
                }
            }
        });
    }
    public void logOut(ActionEvent event){
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        System.out.println("you successfully loggod out");
        stage.close();
    }
}
