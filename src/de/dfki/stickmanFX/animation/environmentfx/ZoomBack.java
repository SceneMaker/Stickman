package de.dfki.stickmanFX.animation.environmentfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
import javafx.application.Platform;
import javafx.scene.layout.HBox;

/**
 *
 * @author Robbie
 *
 */
public class ZoomBack extends AnimationFX {

    public ZoomBack(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // make StickmanSwing to become original size
        mStickmanFX.mScale = mStickmanFX.mScaleOriginal;

        String mStageIdentifier = mStickmanFX.getStageController().getStageIdentifier();
        HBox mStickmanPane;
        try {
            Platform.runLater(() -> {
                try {
                    mStickmanFX.getStageController().getStickmanStage().addStickmanToStage(mStageIdentifier);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Platform.runLater(() -> mStickmanFX.update());
    }
}
