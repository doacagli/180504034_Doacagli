package com.example.nolurson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminUpdateController implements Initializable {
    @FXML
    private Button updateButton;

    @FXML
    private ChoiceBox<String> myChoiceBox;

    @FXML
    private TextField altWert;

    @FXML
    private TextField neWert;
    @FXML
    private TextField Bid;
    @FXML
    private Label errmess;

    private String [] Update ={"Benutzername","Passwort","Arbeitsstelle","PersonalID"};

    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(Update);

    }
    public void updateWerten(ActionEvent event){
        if (myChoiceBox.getValue()== "Benutzername"){
            Database.updateBenutzername(Bid.getText(),neWert.getText());
            System.out.println("correct");
        }else{
            System.out.println("false");
        }
        System.out.println("finish");

    }
}
