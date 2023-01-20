package com.example.demo.Modules.Login;

import javafx.beans.property.BooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LoginPane extends BorderPane {
    BooleanProperty loginProperty;
    public LoginPane(){
        UsernameField usernameField = new UsernameField();
        MyPasswordField passwordField = new MyPasswordField();
        LoginButton loginButton = new LoginButton("Login");
        loginProperty = loginButton.loginProperty();
        VBox vBox = new VBox(usernameField,passwordField,loginButton);
        vBox.setSpacing(25);
        this.setMaxSize(500,500);
        vBox.setAlignment(Pos.CENTER);
        this.setCenter(vBox);
    }

    public BooleanProperty loginProperty(){
        return loginProperty;
    }
}
