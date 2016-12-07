package de.dfki.stickman3D.animation.environmentfx;

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
public class Breathing {

    private Stickman3D mStickmanFX;
    private Timeline breathTimeline;

    public Breathing(Stickman3D s, int breathFrequent, int actionDuration) {
        this.mStickmanFX = s;
        startBreathing(breathFrequent, actionDuration);
    }
    

    // AtmenAktion
    public void startBreathing(int breathFrequent, int actionDuration) throws IllegalArgumentException{
        if(actionDuration * 2> breathFrequent)
            throw new IllegalArgumentException("value breathFrequent must be at least 2 times greater than value actionDuration");
            
        breathTimeline = new Timeline(new KeyFrame(Duration.millis(breathFrequent), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(actionDuration),
                        mStickmanFX.mUpperBody.mUpperBodyGroup);
                scaleTransition.setToX(1.05f);
                scaleTransition.setToZ(1.05f);
                scaleTransition.setToY(1.01f);
                scaleTransition.setCycleCount(2);
                scaleTransition.setAutoReverse(true);
                scaleTransition.play();
            }
        }));
        breathTimeline.setCycleCount(Timeline.INDEFINITE);
        breathTimeline.play();
    }

    public void stopBreathAktion() {
        if (breathTimeline != null) {
            breathTimeline.stop();
        }
    }
}
