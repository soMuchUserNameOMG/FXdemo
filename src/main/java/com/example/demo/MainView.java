package com.example.demo;

import com.example.demo.Modules.Loading.LoadingStage;
import com.example.demo.Modules.Login.LoginPane;
import com.example.demo.Modules.LoginLoading.LoadingPane;
import com.example.demo.Modules.Main.MainStage;
import com.example.demo.Utils.Animation.FadeIn;
import com.example.demo.Utils.Animation.FadeOut;
import com.example.demo.Utils.Shadows;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MainView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        boolean Load = false;
        if(Load){
            //加载效果一
            primaryStage.setTitle("Login");
            BorderPane root = new BorderPane();
            root.setStyle("-fx-background-color: white");
            root.setEffect(Shadows.WINDOW_SHADOW);
            Scene scene = new Scene(root,600,500);
            LoginPane loginPane = new LoginPane();
            loginPane.loginProperty().addListener(((observable, oldValue, newValue) -> {
                primaryStage.close();
                LoadingStage loadingStage  = new LoadingStage(1000,750);
                loadingStage.show();
                loadingStage.isOver().addListener(((observable1, oldValue1, newValue1) -> {
                    if(newValue1) {
                        loadingStage.close();
                        MainStage mainStage = new MainStage(1000,750);
                        mainStage.show();
                    }
                }));
            }));
            root.setCenter(loginPane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            //加载效果二
            primaryStage.setTitle("Logn");
            BorderPane root = new BorderPane();
            LoginPane loginPane = new LoginPane();
            FadeOut fadeOut =new FadeOut(loginPane);
            loginPane.loginProperty().addListener(((observable, oldValue, newValue) -> {
                if(newValue){
                    fadeOut.play();
                    fadeOut.setOnFinished().setOnFinished(event -> {
                        LoadingPane loadingPane = new LoadingPane();
                        FadeIn fadeIn = new FadeIn(loadingPane);
                        fadeIn.play();
                        root.setCenter(loadingPane);
                    });
                }
            }));
            root.setCenter(loginPane);
            primaryStage.setScene(new Scene(root,700,450));
            primaryStage.show();

        }
    }
}
