package de.dfki.stickman3D.animation.environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import de.dfki.stickman3D.Stickman3D;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class Blinking {

    private Stickman3D mStickmanFX;
    private Timeline blinkTimeline;

    public Blinking(Stickman3D s, int frequent, int actionDuration) {
        this.mStickmanFX = s;
        System.out.println(frequent + " " + actionDuration);
        startBlinkAktion(frequent, actionDuration);
    }

    public void startBlinkAktion(int frequent, int actionDuration) {
        blinkTimeline = new Timeline(new KeyFrame(Duration.millis(frequent), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mStickmanFX.doAnimation("Blink", actionDuration, true);
            }
        }));
        blinkTimeline.setCycleCount(Timeline.INDEFINITE);
        blinkTimeline.play();
    }

    public void stopBlinkAktion() {
        if (blinkTimeline != null) {
            blinkTimeline.stop();
        }
    }
}
