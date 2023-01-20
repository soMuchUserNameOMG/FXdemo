package com.example.demo.Modules.Login;

import com.example.demo.Utils.NiceColors;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class MyPasswordField extends BorderPane {
    HBox hBox;
    Rectangle line;
    Label lock = new Label();
    Label eye = new Label();
    PasswordField passwordField = new PasswordField();

    TextField textField = new TextField();
    BorderPane passwordMainField = new BorderPane();
    boolean isVisible = false;
    public MyPasswordField(){
        passwordMainField.setMaxSize(280,40);
        passwordMainField.setId("username-field");
        passwordMainField.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Login/Login.css")));
        passwordMainField.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            if(!passwordField.isFocused() & !textField.isFocused()){
                passwordMainField.setStyle("-fx-border-color: #0D90EE");
                lock.setStyle("-fx-text-fill: #0D90EE");
                passwordField.setStyle("-fx-prompt-text-fill: #0D90EE");
            }
        });
        passwordMainField.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            if(!passwordField.isFocused() & !textField.isFocused()){
                passwordMainField.setStyle("-fx-border-color: #767676");
                lock.setStyle("-fx-text-fill: #767676");
                passwordField.setStyle("-fx-prompt-text-fill: #767676");
            }
        });
        Font font = Font.loadFont(getClass().getResourceAsStream("/Icons/icomoon.ttf"),28);
        lock.setFont(font);
        lock.setText("\ue904");
        lock.setTextFill(NiceColors.GRAY);
        lock.setId("icon");
        lock.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Login/Login.css")));
        line = new Rectangle(1.5,26);
        line.setFill(NiceColors.GRAY);
        line.fillProperty().bind(lock.textFillProperty());
        eye.setFont(Font.font(font.getFamily(),20));
        eye.setText("\ue905");
        eye.textFillProperty().bind(lock.textFillProperty());
        eye.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {
            if(!isVisible){
                eye.setText("\ue900");
                textField.setText(passwordField.getText());
                textField.setPrefHeight(40);
                textField.setId("text-field");
                textField.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Login/Login.css")));
                hBox.getChildren().set(2,textField);
                isVisible = true;
                textField.focusedProperty().addListener(((observable, oldValue, newValue) -> {
                    if(newValue) {
                        passwordField.setPromptText("");
                        passwordMainField.setStyle("-fx-border-color: #0D90EE");
                        lock.setStyle("-fx-text-fill: #0D90EE");
                    } else {
                        passwordField.setPromptText("Press your password");
                        passwordField.setStyle("-fx-prompt-text-fill: #767676");
                        passwordMainField.setStyle("-fx-border-color: #767676");
                        lock.setStyle("-fx-text-fill: #767676");
                    }
                }));
                passwordField.textProperty().bind(textField.textProperty());
                textField.requestFocus();
                textField.positionCaret(passwordField.getText().length());
            } else {
                eye.setText("\ue905");
                hBox.getChildren().set(2,passwordField);
                isVisible = false;
                passwordField.requestFocus();
                passwordField.positionCaret(textField.getText().length());
            }
        });
        passwordField.setPrefHeight(40);
        passwordField.setPromptText("Press your password");
        passwordField.setId("text-field");
        passwordField.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Login/Login.css")));
        passwordField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) {
                passwordField.setPromptText("");
                passwordMainField.setStyle("-fx-border-color: #0D90EE");
                lock.setStyle("-fx-text-fill: #0D90EE");
            } else {
                passwordField.setPromptText("Press your password");
                passwordField.setStyle("-fx-prompt-text-fill: #767676");
                passwordMainField.setStyle("-fx-border-color: #767676");
                lock.setStyle("-fx-text-fill: #767676");
            }
        });
        hBox = new HBox(lock,line, passwordField,eye);
        hBox.setAlignment(Pos.CENTER_LEFT);
        passwordMainField.setCenter(hBox);
        Label label = new Label("Password");
        label.setId("label");
        VBox vBox = new VBox(label, passwordMainField);
        vBox.setAlignment(Pos.CENTER_LEFT);
        this.setMaxSize(280,50);
        this.setCenter(vBox);
    }
}
