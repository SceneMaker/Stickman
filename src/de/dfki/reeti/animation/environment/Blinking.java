package de.dfki.reeti.animation.environment;

import de.dfki.reeti.Reeti;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public final class Blinking {

    private final Reeti mStickmanFX;
    private Timeline blinkTimeline;

    public Blinking(Reeti s, int frequent, int actionDuration) {
        this.mStickmanFX = s;
        System.out.println(frequent + " " + actionDuration);
        startBlinkAktion(frequent, actionDuration);
    }

    public void startBlinkAktion(int frequent, int actionDuration) {
        blinkTimeline = new Timeline(new KeyFrame(Duration.millis(frequent), (ActionEvent event) -> {
            mStickmanFX.doAnimation("Blink", actionDuration, false);
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
