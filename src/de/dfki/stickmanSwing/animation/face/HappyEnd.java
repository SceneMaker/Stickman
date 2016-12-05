package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class HappyEnd extends AnimationSwing {

    public HappyEnd(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // happy end
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "HAPPYEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "HAPPYEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "HAPPYEND"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
