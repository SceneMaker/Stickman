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
public class HappyStart extends AnimationSwing {

    public HappyStart(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // happy start
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "HAPPY"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "HAPPY"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "HAPPY"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
