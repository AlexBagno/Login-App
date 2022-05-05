package com.example.loginscreen.controller;

import com.example.loginscreen.Application;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContactUsController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton contactUsBackButton;

    @FXML
    void initialize() {
        contactUsBackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    backButton();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    void backButton() throws IOException {
        contactUsBackButton.getScene().getWindow().hide();


        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("details.fxml"));
        Scene backDetailsScene = new Scene(fxmlLoader.load());
        Stage backDetailsStage = new Stage();

        DetailsController detailsController = fxmlLoader.getController();
        detailsController.setName(backName, backProfession, 16);

        backDetailsStage.setScene(backDetailsScene);
        backDetailsStage.show();
        backDetailsStage.setResizable(false);

    }
    private String backName;
    private String backProfession;

    void labelSaver(String name,String profession) {
        backName = name;
        backProfession = profession;
    }
}
