package com.example.demo.Modules.Loading;

import com.example.demo.Utils.Shadows;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoadingStage extends Stage {
    private LoadingBar loadingBar;

    public LoadingStage(int width,int height) {
        loadingBar = new LoadingBar(0);
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: white");
        borderPane.setEffect(Shadows.WINDOW_SHADOW);
        Scene scene = new Scene(borderPane,width,height);
        this.setScene(scene);
        Button button = new Button("Click me!");
        button.setOnAction(event -> {
            loadingBar.startAnimation();
        });
        VBox vBox = new VBox(loadingBar,button);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        borderPane.setCenter(vBox);
    }

    public BooleanProperty isOver(){
        return loadingBar.isOverProperty();
    }
}
