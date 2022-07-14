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

public class KlientAdminController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<Klient> table_klient;

    @FXML
    private TableColumn<Klient, String> col_nam;

    @FXML
    private TableColumn<Klient, String> col_nachn;

    @FXML
    private TableColumn<Klient, String> col_id;

    @FXML
    private TableColumn<Klient, String> col_adresse;

    @FXML
    private TableColumn<Klient,String> col_tel;

    @FXML
    private TableColumn<Klient,String> col_bdate;

    @FXML
    private TableColumn<Klient,String> col_sex;

    @FXML
    private TableColumn<Klient,String> col_mail;

    @FXML
    private TableColumn<Klient, String > col_dateinnm;

    @FXML
    private Button backToButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button but_update;

    @FXML
    private ChoiceBox<String> updatebox;

    @FXML
    private Button but_add;

    @FXML
    private Button but_delete_;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_nname;

    @FXML
    private TextField txt_adresse;

    @FXML
    private TextField txt_tel;

    @FXML
    private DatePicker DateBox;

    @FXML
    private ChoiceBox<String> myChoiceBox;

    @FXML
    private TextField txt_mail;
    @FXML
    private Label errorMessage;

    @FXML
    private TextField txt_dateinnummer;
    private String [] Geschlecht ={"W","M","D"};
    private String [] Updatebar={"Vorname", "Nachname","MailAdresse","Telefonnummer","Geburtsdatum","Adresse","DateinNummer"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        col_nam.setCellValueFactory(new PropertyValueFactory<Klient,String>("Vorname"));
        col_nachn.setCellValueFactory(new PropertyValueFactory<Klient,String>("Nachname"));
        col_id.setCellValueFactory(new PropertyValueFactory<Klient,String>("BurgerID"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<Klient, String >("Adresse"));
        col_tel.setCellValueFactory(new PropertyValueFactory<Klient, String>("Telefonnummer"));
        col_bdate.setCellValueFactory(new PropertyValueFactory<Klient, String>("Geburtsdatum"));
        col_sex.setCellValueFactory(new PropertyValueFactory<Klient, String>("Geschlecht"));
        col_mail.setCellValueFactory(new PropertyValueFactory<Klient, String >("MailAdresse"));
        col_dateinnm.setCellValueFactory(new PropertyValueFactory<Klient, String>("DateinNummer"));
        table_klient.setItems(List());
        myChoiceBox.getItems().addAll(Geschlecht);
        updatebox.getItems().addAll(Updatebar);
    }
    @FXML
    public ObservableList List(){
        ObservableList arr = Database.listKlient();

        return arr;
    }
    public void backTo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
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
    public void deleteKlient(ActionEvent event) throws IOException {
        Database.deleteKlient(txt_id.getText());

    }
    public void addKlient(ActionEvent event){
        Boolean b = Database.addKlient(txt_id.getText(),txt_name.getText(),txt_nname.getText(),txt_adresse.getText(),txt_tel.getText(),DateBox.getValue().toString(),txt_mail.getText(),myChoiceBox.getValue(),txt_dateinnummer.getText());

        if(b){
            errorMessage.setText("Einfuegen erfolgreich!");
        }else{
            errorMessage.setText("Die Personal ist schon auf dem System befunden.");
        }
    }
    public void updateWerten(ActionEvent event){
        if (updatebox.getValue()== "Vorname"){
            Database.updateKlientVorname(txt_id.getText(),txt_name.getText());
            errorMessage.setText("Einfuegen erfolgreich!");
        }else if(updatebox.getValue() == "Nachname") {
            Database.updateKlientNachname(txt_id.getText(), txt_nname.getText());
            errorMessage.setText("Einfuegen erfolgreich!");
        }else if(updatebox.getValue() == "Adresse"){
            Database.updateKlientAdresse(txt_id.getText(), txt_adresse.getText());
            errorMessage.setText("Einfuegen erfolgreich!");
        }else if(updatebox.getValue() == "Telefonnummer") {
            Database.updatePersonalID(txt_id.getText(), txt_tel.getText());
            errorMessage.setText("Einfuegen erfolgreich!");
        }else if(updatebox.getValue() == "Geburtsdatum") {
        Database.updateKlientGeburtsdatum(txt_id.getText(), DateBox.getValue().toString());
        errorMessage.setText("Einfuegen erfolgreich!");
        }else if(updatebox.getValue() == "MailAdresse"){
            Database.updateKlientMail(txt_id.getText(), txt_mail.getText());
            errorMessage.setText("Einfuegen erfolgreich!");
        }else if(updatebox.getValue() == "DateinNummer") {
            Database.updatePersonalID(txt_id.getText(), txt_dateinnummer.getText());
            errorMessage.setText("Einfuegen erfolgreich!");
        }
        else{
            System.out.println("False");
        }

    }
}
