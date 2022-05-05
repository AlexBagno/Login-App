package com.example.loginscreen.controller;

import com.example.loginscreen.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton loginButton;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private TextField loginUsername;

    @FXML
    void initialize() {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Login was clicked");
                if (!loginUsername.getText().trim().equals("")
                        && !loginPassword.getText().trim().equals("")) {
                    try {
                        loginUser();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    private void loginUser() throws IOException {

        loginButton.getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("details.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage detailsStage = new Stage();
        detailsStage.setScene(scene);
        DetailsController detailsController = fxmlLoader.getController();
        detailsController.setName(loginUsername.getText(), "Java and App Developer", 16);
        detailsController.saveInfo(loginUsername.getText(), "Java and App Developer");
        detailsStage.show();
        detailsStage.setResizable(false);
    }
}