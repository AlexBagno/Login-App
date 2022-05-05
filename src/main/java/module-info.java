module com.example.loginscreen {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.desktop;


    opens com.example.loginscreen to javafx.fxml;
    exports com.example.loginscreen;
    exports com.example.loginscreen.controller;
    opens com.example.loginscreen.controller to javafx.fxml;
}