package com.example.nolurson;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BenutzerUserController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> updateBox;

    @FXML
    private TextField txt_newert;

    @FXML
    private TextField txt_bname;

    @FXML
    private Label txt_bn;

    @FXML
    private Button backToButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button but_update;
    @FXML
    private Label ttt;

    @FXML
    private Label tt;


    private String [] Updatebar={"Vorname", "Nachname","MailAdresse","Telefonnummer","Adresse","Benutzername","Passwort"};
    @FXML
    public void getUsername(String username){
        txt_bn.setText("Hallo! " +username);

    }

    public void backTo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2UserController.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void logOut(ActionEvent event){
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        System.out.println("you successfully loggod out");
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        updateBox.getItems().addAll(Updatebar);
    }

    public void updateWerten(ActionEvent event){
        if (updateBox.getValue()== "Benutzername"){
            Database.updateUserBenutzername(txt_bname.getText(),txt_newert.getText());
            //errormess.setText("Einfuegen erfolgreich!");
        }else if(updateBox.getValue() == "Passwort") {
            Database.updateUserPasswort(txt_bname.getText(),txt_newert.getText());
            //errormess.setText("Einfuegen erfolgreich!");
        }else if(updateBox.getValue() == "Vorname"){
            Database.updateUserVorname(txt_bname.getText(),txt_newert.getText());
            //errormess.setText("Einfuegen erfolgreich!");
        }else if(updateBox.getValue() == "Nachname") {
            Database.updateUserNachname(txt_bname.getText(),txt_newert.getText());
            //errormess.setText("Einfuegen erfolgreich!");
        }else if(updateBox.getValue() == "MailAdresse") {
            Database.updateUserMailAdresse(txt_bname.getText(),txt_newert.getText());
            //errormess.setText("Einfuegen erfolgreich!");
        }else if(updateBox.getValue() == "Telefonnummer"){
            Database.updateUserTel(txt_bname.getText(),txt_newert.getText());
            //errormess.setText("Einfuegen erfolgreich!");
        }else if(updateBox.getValue() == "Adresse") {
            Database.updateUserAdresse(txt_bname.getText(),txt_newert.getText());
            //errormess.setText("Einfuegen erfolgreich!");
        }
        else{
            System.out.println("False");
        }

    }

}
