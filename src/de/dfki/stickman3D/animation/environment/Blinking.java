package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 * @author Beka Aptsiauri
 */
public final class Blinking
{

    private final Stickman3D mStickmanFX;
    private Timeline blinkTimeline;

    public Blinking(Stickman3D s, int frequent, int actionDuration)
    {
        this.mStickmanFX = s;
        startBlinkAktion(frequent, actionDuration);
    }

    public void startBlinkAktion(int frequent, int actionDuration)
    {
        blinkTimeline = new Timeline(new KeyFrame(Duration.millis(frequent), (ActionEvent event) ->
        {
            mStickmanFX.doAnimation("Blink", actionDuration, true);
        }));
        blinkTimeline.setCycleCount(Timeline.INDEFINITE);
        blinkTimeline.play();
    }

    public void stopBlinkAktion()
    {
        if (blinkTimeline != null)
        {
            blinkTimeline.stop();
        }
    }
}
