/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 23-05-2022
Time: 11:25 AM
File: DashboarView.java */
package io.github.prajjwal.florio_project.controller;

import io.github.prajjwal.florio_project.database.DatabaseConnection;
import io.github.prajjwal.florio_project.database.helper.AddAddressHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.slf4j.Logger;

import java.sql.SQLException;

public class DashboardController {

    @FXML
    public Label userNameLabel;

    @FXML
    public Label emailLabel;

    @FXML
    public Button addAddressButton;

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

    @FXML
    public TextField addressTextField;

    @FXML
    public void onAddAddressButtonClick() {
        DatabaseConnection connection = new DatabaseConnection();
        try {
            connection.createConnection();
        } catch (SQLException e) {
            //Looger
        }
        String address = addressTextField.getText();
        AddAddressHelper addAddressHelper = new AddAddressHelper();
        try {
            addAddressHelper.addAddress(connection.getConnection(), address);
            showAlert(Alert.AlertType.INFORMATION, "Successful", "Address added Successfully!");
        } catch (SQLException e) {
            //Logger
        }
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}