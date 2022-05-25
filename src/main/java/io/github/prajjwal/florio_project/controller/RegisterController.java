/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 22-05-2022
Time: 7:38 PM
File: RegisterView.java */
package io.github.prajjwal.florio_project.controller;

import io.github.prajjwal.florio_project.HelloApplication;
import io.github.prajjwal.florio_project.database.DatabaseConnection;
import io.github.prajjwal.florio_project.database.helper.RegisterHelper;
import io.github.prajjwal.florio_project.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class RegisterController {

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private PasswordField registerPasswordField;

    @FXML
    private Button registerButton;

    @FXML
    public void onRegisterButtonClick() throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        connection.createConnection();
        connection.printConnectionStatus();
        // Insert data into database from these fields
        String name = nameTextField.getText();
        long phone = Long.parseLong(phoneTextField.getText());
        String email = emailTextField.getText();
        String password = registerPasswordField.getText();

        // Insert data into User Object
        User user = new User(name, phone, email, password);
        // Insert data into database
        RegisterHelper registerHelper = new RegisterHelper();
        registerHelper.createUser(connection.getConnection(), user);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successful");
        alert.setContentText("Successfully Registered");
        alert.show();
    }

    @FXML
    public void onRegisterLoginButtonClick() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader  = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Login to Florio");
        stage.setScene(scene);
        stage.show();
        closeCurrentStage();
    }

    private void closeCurrentStage() {
        Stage stage = (Stage) this.registerButton.getScene().getWindow();
        stage.close();
    }
}