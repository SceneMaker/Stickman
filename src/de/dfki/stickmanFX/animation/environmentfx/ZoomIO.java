package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationStickman2D;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * @author Robbie
 */
public class ZoomIO extends AnimationStickman2D
{

    public ZoomIO(StickmanFX sm, int duration, boolean block)
    {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation()
    {
        // make StickmanSwing to become 4 times big. Focus on StickmanSwing's face.
//        mStickman.mScale = 4f;
        String sParameter = (String) mParameter;
        sParameter = sParameter.trim();

        try
        {
            agent.mScale = Float.parseFloat(sParameter);
        } catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        String mStageIdentifier = agent.getStageRoom().getStageIdentifier();
        HBox mStickmanPane;
        try
        {
            mStickmanPane = agent.getStageRoom().getAgentStage()
                    .getAgentBox(mStageIdentifier);
            Platform.runLater(() -> mStickmanPane.getChildren().clear());
            Platform.runLater(() ->
            {
                try
                {
                    agent.getStageRoom().getAgentStage().addAgentToStage(mStageIdentifier,
                            ((StickmanFX) agent));
                    mStickmanPane.setAlignment(Pos.CENTER);
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
