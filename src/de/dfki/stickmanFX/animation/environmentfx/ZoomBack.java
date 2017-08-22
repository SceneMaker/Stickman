package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;
import javafx.application.Platform;
import javafx.scene.layout.HBox;

/**
 * @author Robbie
 */
public class ZoomBack extends AnimationStickman2D
{

    public ZoomBack(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // make StickmanSwing to become original size
        agent.mScale = ((StickmanFX) agent).mScaleOriginal;

        String mStageIdentifier = agent.getStageRoom().getStageIdentifier();
        HBox mStickmanPane;
        try
        {
            Platform.runLater(() ->
            {
                try
                {
                    agent.getStageRoom().getAgentStage().addAgentToStage(mStageIdentifier);
                } catch (Exception e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Platform.runLater(() -> ((StickmanFX) agent).update());
    }
}
