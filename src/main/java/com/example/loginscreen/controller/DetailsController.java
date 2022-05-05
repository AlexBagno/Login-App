package com.example.loginscreen.controller;

import com.example.loginscreen.Application;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;


public class DetailsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label detailsId;

    @FXML
    private JFXButton detailsContactUs;

    @FXML
    private Label detailsName;

    @FXML
    private Label detailsProfession;

    @FXML
    private Hyperlink detailsTwitter;

    @FXML
    private Hyperlink detailsWeb;

    @FXML
    private Label detailsWelcomeLabel;

    @FXML
    void initialize() {
        detailsWeb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://github.com/AlexBagno"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        detailsTwitter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://www.reddit.com/user/Enothed/"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        detailsContactUs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    contactUsPage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private String labelName;
    private String labelProfession;

    void saveInfo(String name, String profession) {
        labelName= name;
        labelProfession = profession;
    }

    void setName(String name, String profession, int age) {
        detailsWelcomeLabel.setText("Welcome " + name);
        detailsName.setText("Name: " + name);
        detailsId.setText("Age: " + age);
        detailsProfession.setText("Profession: " + profession);
    }


    void contactUsPage() throws IOException {
        detailsContactUs.getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("contactUs.fxml"));
        Scene contactUsScene = new Scene(fxmlLoader.load());
        Stage contactUsStage = new Stage();
        contactUsStage.setScene(contactUsScene);
        contactUsStage.show();
        contactUsStage.setResizable(false);

        ContactUsController contactUsController = fxmlLoader.getController();
        contactUsController.labelSaver(labelName, labelProfession);
    }
}
