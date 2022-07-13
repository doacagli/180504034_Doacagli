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

public class AdminUpdateController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

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
    @FXML
    private TableView<Benutzer> BenutzerTableView;

    @FXML
    private TableColumn<Benutzer, String> BenutzernameID;

    @FXML
    private TableColumn<Benutzer, String> PersonalIDID;

    @FXML
    private TableColumn<Benutzer, String > col_passwort;

    @FXML
    private TableColumn<Benutzer, String> col_arbeit;
    @FXML
    private TableColumn<Benutzer, String> txt_bidd;



    private String [] Update ={"Benutzername","Passwort","Arbeitsstelle","PersonalID"};

    public void initialize(URL url, ResourceBundle resourceBundle) {
        BenutzernameID.setCellValueFactory(new PropertyValueFactory<Benutzer, String>("Benutzername"));
        PersonalIDID.setCellValueFactory(new PropertyValueFactory<Benutzer, String>("PersonalID"));
        col_passwort.setCellValueFactory(new PropertyValueFactory<Benutzer, String >("Passwort"));
        col_arbeit.setCellValueFactory(new PropertyValueFactory<Benutzer, String>("Arbeitsstelle"));
        txt_bidd.setCellValueFactory(new PropertyValueFactory<Benutzer, String>("BurgerID"));
        BenutzerTableView.setItems(ListBenutzer());
        myChoiceBox.getItems().addAll(Update);

    }
    @FXML
    public ObservableList ListBenutzer(){
        ObservableList arr = Database.listBenutzer();
        return arr;
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
    public void logOut(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        System.out.println("you successfully loggod out");
        stage.close();
    }
    public void backTo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
