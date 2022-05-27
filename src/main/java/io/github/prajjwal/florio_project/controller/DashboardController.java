/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 23-05-2022
Time: 11:25 AM
File: DashboarView.java */
package io.github.prajjwal.florio_project.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    public Label userNameLabel;
    @FXML
    public Button acRepairingButton;

    @FXML
    public Button coolerRepairingButton;

    @FXML
    public Button machineRepairingButton;

    @FXML
    public Button tvRepairingButton;

    @FXML
    public Button laptopRepairingButton;

    @FXML
    public Button homeButton;

    @FXML
    public Button orderDetailsButton;

    @FXML
    public Button editUserButton;


    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}