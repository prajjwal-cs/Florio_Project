package io.github.prajjwal.florio_project.controller;

import io.github.prajjwal.florio_project.HelloApplication;
import io.github.prajjwal.florio_project.database.helper.LoginHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    public void onLoginButtonClick() {
        if(emailTextField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Username cannot be empty");
        }
        if (passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Password cannot be empty");
        }
        isValidPassword();

        LoginHelper loginHelper = new LoginHelper();
        boolean isValid = false;
        try {
            isValid = loginHelper.loginUser(emailTextField.getText(), passwordField.getText());
        } catch (SQLException e) {
            logger.error("Not a Valid password");
        }
        if (isValid) {
            openDashboard();
            closeCurrentStage();
            showAlert(Alert.AlertType.INFORMATION, "Success", "Login Successful");
        }
        else {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid Username or Password");
        }


    }

    private void openDashboard() {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("dashboard-view.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setTitle("Florio");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    private void isValidPassword() {
        final String regex = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$";
        if (!passwordField.getText().matches(regex)) {
            showAlert(Alert.AlertType.ERROR, "Error",
                    "Password must contain at least one digit, one upper case letter, " +
                            "one lower case letter, one special character and must be between 8 and" +
                            " 16 characters long");
        }
    }

    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    private void closeCurrentStage() {
        Stage stage = (Stage) this.loginButton.getScene().getWindow();
        stage.close();
    }
}