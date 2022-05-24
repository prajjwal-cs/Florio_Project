package io.github.prajjwal.florio_project.controller;

import io.github.prajjwal.florio_project.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField emailOrPhone;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    public void onLoginButtonClick() {
    }

    @FXML
    public void onLoginRegisterButtonClick() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader  = new FXMLLoader(HelloApplication.class.getResource("register-view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Register Florio");
        stage.setScene(scene);
        stage.show();
        closeCurrentStage();
    }

    private void closeCurrentStage() {
        Stage stage = (Stage) this.loginButton.getScene().getWindow();
        stage.close();
    }
}