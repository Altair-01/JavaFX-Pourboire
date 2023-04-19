package com.example.projectfx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;

import java.text.DecimalFormat;

public class HelloController {

    @FXML
    private TextField montant;

    @FXML
    private RadioButton radioButton15;

    @FXML
    private RadioButton radioButton20;

    @FXML
    private Label resultLabel;

    private ToggleGroup toggleGroup;



    // mÉTHODE DE CALCUL SANS LAMBDA
   /* @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        double taux = 0.0;

        if (radioButton15.isSelected()) {
            taux = 0.15;
        } else if (radioButton20.isSelected()) {
            taux = 0.20;
        }

        double input = Double.parseDouble(montant.getText());
        double pourboire = input * taux;
        double total = input + pourboire;

        //resultLabel.setText(String.format("Total: %.2f (dont pourboire %.2f)", total, pourboire)); // Une autre vue proposée
        resultLabel.setText(String.format("%.2f", pourboire));
    }*/

    // 3. Changez votre code pour utiliser une expression lambda pour faire le calcul
   /* @FXML
    public void onHelloButtonClick(ActionEvent event) {
        double input = Double.parseDouble(montant.getText());
        double pourboire = radioButton15.isSelected() ? 0.15 : 0.20;
        double resultat = input * pourboire;
        DecimalFormat df = new DecimalFormat("#.00");
        resultLabel.setText(df.format(resultat));
    }*/

    //aJOUTEZ UN TRY... CATCH
    @FXML
    private void onHelloButtonClick(ActionEvent event) {
        try {
            double input = Double.parseDouble(montant.getText());
            double pourboire = radioButton15.isSelected() ? 0.15 : 0.20;
            double resultat = input * pourboire;
            DecimalFormat df = new DecimalFormat("#.00");
            resultLabel.setText(df.format(resultat));
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur");
            alert.setContentText("Entrée invalide");
            alert.showAndWait();
        }
    }


    @FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();
        radioButton15.setToggleGroup(toggleGroup);
        radioButton20.setToggleGroup(toggleGroup);
    }
}
