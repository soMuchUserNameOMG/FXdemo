package com.example.demo.Utils.Animation;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeOut {
    TranslateTransition translateTransition;
    FadeTransition fadeTransition;
    ScaleTransition scaleTransition;
    public FadeOut(Node node) {
        translateTransition = new TranslateTransition(Duration.seconds(0.4),node);
        translateTransition.setByX(-40);
        fadeTransition = new FadeTransition(Duration.seconds(0.4),node);
        fadeTransition.setByValue(-1);
        scaleTransition = new ScaleTransition(Duration.seconds(0.4),node);
        scaleTransition.setByY(-0.1);
        scaleTransition.setByX(-0.1);
    }

    public void play(){
        translateTransition.play();
        fadeTransition.play();
        scaleTransition.play();
    }

    public TranslateTransition setOnFinished(){
        return  translateTransition;
    }
}
