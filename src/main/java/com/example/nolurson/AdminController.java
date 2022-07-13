package com.example.nolurson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button logout;

    @FXML
    private Button backToButton;

    @FXML
    private Button addUser;
    
    @FXML
    private TextField deleteBenutzer;
    @FXML
    private Button deleteButton;

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

    @FXML
    private TextField txt_pid;

    @FXML
    private TextField txt_bn;

    @FXML
    private TextField txt_pss;

    @FXML
    private ChoiceBox<String> adminbox;

    private String [] Arbeitsstelle ={"Admin","User"};
    private String [] Geschlecht ={"W","M","D"};
    @FXML
    private Label errormess;

    @FXML
    private TextField txt_bid;

    @FXML
    private TextField txt_vn;

    @FXML
    private TextField txt_nn;

    @FXML
    private TextField txt_adresse;

    @FXML
    private TextField txt_tel;

    @FXML
    private ChoiceBox<String> myChoiceBox;

    @FXML
    private TextField txt_mail;

    @FXML
    private DatePicker DateBox;

    @FXML
    private ChoiceBox<String> updatebox;
    @FXML
    private AnchorPane scenepane;

    @FXML
    private Button but_update;
    private String [] Updatebar ={"PersonalID","Benutzername","Passwort","Geschlecht","Vorname","Nachname","Adresse", "Geburtsdatum","Mail","Admin","BurgerID","Telefonnummer"};

    ObservableList<Benutzer> Benutzerlist = FXCollections.observableArrayList();
    //Benutzerlist = ListBenutzer();

    @FXML
    public ObservableList ListBenutzer(){
        ObservableList arr = Database.listBenutzer();
        return arr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resource) {

            BenutzernameID.setCellValueFactory(new PropertyValueFactory<Benutzer, String>("Benutzername"));
            PersonalIDID.setCellValueFactory(new PropertyValueFactory<Benutzer, String>("PersonalID"));
            col_passwort.setCellValueFactory(new PropertyValueFactory<Benutzer, String >("Passwort"));
            col_arbeit.setCellValueFactory(new PropertyValueFactory<Benutzer, String>("Arbeitsstelle"));
            txt_bidd.setCellValueFactory(new PropertyValueFactory<Benutzer, String>("BurgerID"));

            BenutzerTableView.setItems(ListBenutzer());
            adminbox.getItems().addAll(Arbeitsstelle);
            myChoiceBox.getItems().addAll(Geschlecht);


    }


    public void backTo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addUser(ActionEvent event) throws IOException {

    }

    public void deleteBenutzer(ActionEvent event) throws IOException {
        Database.deleteBenutzer(txt_bid.getText());

    }

    public void logOut(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        System.out.println("you successfully loggod out");
        stage.close();
    }
    public void addBenutzer(ActionEvent event){
        Boolean b = Database.addBenutzer(txt_bid.getText(),txt_vn.getText(),txt_nn.getText(),txt_adresse.getText(),txt_tel.getText(),DateBox.getValue().toString(),txt_mail.getText(),myChoiceBox.getValue(),txt_pid.getText(),txt_bn.getText(),txt_pss.getText(),adminbox.getValue());

        if(b){
            errormess.setText("Einfuegen erfolgreich!");
        }else{
            errormess.setText("Die Personal ist schon auf dem System befunden.");
        }
    }
    public void UpdateSeite(ActionEvent event) throws IOException{
        FXMLLoader bb = new FXMLLoader(getClass().getResource("AdminUpdateController.fxml"));
        root = bb.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
