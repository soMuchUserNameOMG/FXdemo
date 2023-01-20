package com.example.demo.Utils.Animation;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeIn {
    TranslateTransition translateTransition;
    FadeTransition fadeTransition;
    ScaleTransition scaleTransition;
    public FadeIn(Node node) {
        translateTransition = new TranslateTransition(Duration.seconds(0.4),node);
        translateTransition.setFromX(40);
        translateTransition.setToX(0);
        fadeTransition = new FadeTransition(Duration.seconds(0.4),node);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        scaleTransition = new ScaleTransition(Duration.seconds(0.4),node);
        scaleTransition.setFromY(0.9);
        scaleTransition.setFromY(0.9);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
    }

    public void play(){
        translateTransition.play();
        fadeTransition.play();
        scaleTransition.play();
    }
}
