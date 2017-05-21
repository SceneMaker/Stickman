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
public class ExcitedEnd extends AnimationSwing {

    public ExcitedEnd(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // excited end
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "EXCITEDEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "EXCITEDEND"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
