package com.example.demo.Modules.Login;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class LoginButton extends Button {
    BooleanProperty loginProperty = new SimpleBooleanProperty(false);
    public LoginButton(String text) {
        super(text);
        this.setMaxSize(100,30);
        this.setId("login-button");
        this.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Login/Login.css")));
        this.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {
            loginProperty.set(true);
        });
    }

    public BooleanProperty loginProperty(){
        return loginProperty;
    }
}
