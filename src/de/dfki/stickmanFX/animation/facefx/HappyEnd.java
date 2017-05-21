package de.dfki.stickmanFX.animation.facefx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;
import java.util.ArrayList;

/**
 *
 * @author beka
 *
 */
public class HappyEnd extends AnimationFX {

    public HappyEnd() {
        super();
    }

    public HappyEnd(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // no happy
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "HAPPYEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "HAPPYEND"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "HAPPYEND"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
