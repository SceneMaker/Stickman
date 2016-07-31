package de.dfki.stickmanfx.animation.facefx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import java.util.ArrayList;
import javafx.application.Platform;

/**
 *
 * @author Beka
 *
 */
public class HappyStart extends AnimationFX {

    public HappyStart(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // happy start
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "HAPPY"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "HAPPY"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "HAPPY"));
        Platform.runLater(() -> playAnimationPart(mDuration));

        pauseAnimation(10);
    }
}
