package com.example.demo.Modules.Main;

import com.example.demo.Modules.Main.Navigation.NavigationPane;
import com.example.demo.Utils.Shadows;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainStage extends Stage {
    public MainStage(int width,int height) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: white");
        root.setEffect(Shadows.WINDOW_SHADOW);
        Scene scene = new Scene(root,width,height);
        NavigationPane navigationPane = new NavigationPane("Home","User","Support");
        this.setTitle("Main");
        root.setLeft(navigationPane);
        this.setScene(scene);
    }
}
