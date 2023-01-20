package com.example.demo.Modules.Login;

import com.example.demo.Utils.NiceColors;
import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class UsernameField extends BorderPane {
    HBox hBox;
    TextField textField = new TextField();
    Rectangle line;
    Label icon = new Label();
    BorderPane usernameField = new BorderPane();
    public UsernameField(){
        usernameField.setMaxSize(280,40);
        usernameField.setId("username-field");
        usernameField.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Login/Login.css")));
        usernameField.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            if(!textField.isFocused()){
                usernameField.setStyle("-fx-border-color: #0D90EE");
                icon.setStyle("-fx-text-fill: #0D90EE");
                textField.setStyle("-fx-prompt-text-fill: #0D90EE");
            }
        });
        usernameField.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            if(!textField.isFocused()){
                usernameField.setStyle("-fx-border-color: #767676");
                icon.setStyle("-fx-text-fill: #767676");
                textField.setStyle("-fx-prompt-text-fill: #767676");
            }
        });
        Font font = Font.loadFont(getClass().getResourceAsStream("/Icons/icomoon.ttf"),28);
        icon.setFont(font);
        icon.setText("\ue908");
        icon.setTextFill(NiceColors.GRAY);
        icon.setId("icon");
        icon.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Login/Login.css")));
        line = new Rectangle(1.5,26);
        line.setFill(NiceColors.GRAY);
        line.fillProperty().bind(icon.textFillProperty());
        textField.setPrefHeight(40);
        textField.setPromptText("Press your username");
        textField.setId("text-field");
        textField.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Login/Login.css")));
        textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) {
                textField.setPromptText("");
                usernameField.setStyle("-fx-border-color: #0D90EE");
                icon.setStyle("-fx-text-fill: #0D90EE");
            } else{
                textField.setPromptText("Press your username");
                textField.setStyle("-fx-prompt-text-fill: #767676");
                usernameField.setStyle("-fx-border-color: #767676");
                icon.setStyle("-fx-text-fill: #767676");
            }
        });
        hBox = new HBox(icon,line,textField);
        hBox.setAlignment(Pos.CENTER_LEFT);
        usernameField.setCenter(hBox);
        Label label = new Label("Username");
        label.setId("label");
        VBox vBox = new VBox(label,usernameField);
        vBox.setAlignment(Pos.CENTER_LEFT);
        this.setMaxSize(280,50);
        this.setCenter(vBox);
    }
}
