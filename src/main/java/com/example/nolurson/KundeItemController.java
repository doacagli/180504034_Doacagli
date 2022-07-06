package com.example.nolurson;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class KundeItemController {


    @FXML
    private Label fullnameLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label telefonnummerLabel;

    private Klient klient;

    public void setKlientItem(Klient k) {
        fullnameLabel.setText(k.getVorname() + " " + k.getNachname());
        idLabel.setText(k.getBurgerID());
        //telefonnummerLabel.setText(k.getTelefonnummer());
        klient = k;
    }

}
