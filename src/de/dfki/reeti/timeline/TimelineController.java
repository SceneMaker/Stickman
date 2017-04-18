package de.dfki.reeti.timeline;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TimelineController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private ComboBox<?> animationCombo;

    @FXML
    private Button playButton;

    @FXML
    private ScrollPane animationScrollPane;

    @FXML
    private GridPane animationGridPane;

    @FXML
    private Line timeline;

    private boolean isAutomaticScrollStarted = false;
    private boolean isPlayed = false;

    private int timelinePos = 0;

    private Animation autoScrollAnimation;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playButton.setOnMouseClicked(event ->
        {
            isPlayed = !isPlayed;
            startTimeline();
        });
    }

    synchronized public void startTimeline() {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                //############AUTOSCROLL PLAY, PAUSE####################
                if(!isPlayed)
                    autoScrollAnimation.pause();
                else if(isPlayed && autoScrollAnimation != null)
                    autoScrollAnimation.play();
                //############END AUTOSCROLL PLAY, PAUSE################

                while (timelinePos <= 5980 && isPlayed) {

                    int c = timelinePos;
                    if (c >= 700 && !isAutomaticScrollStarted) {
                        isAutomaticScrollStarted = true;
                        startAutoScroll();
                    }
                    Platform.runLater(() -> timeline.setTranslateX(c));

                    timelinePos++;
                    Thread.sleep(10);
                }
                return null;
            }
        };

        Thread th = new Thread(task);
        th.start();
    }

    private void startAutoScroll()
    {
        autoScrollAnimation = new Timeline(
                new KeyFrame(Duration.seconds(10000),
                        new KeyValue(animationScrollPane.hvalueProperty(), 230)));
        autoScrollAnimation.play();
    }
}
