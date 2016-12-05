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
public class ExcitedStart extends AnimationSwing {

    public ExcitedStart(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // excited start
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "EXCITED"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "EXCITED"));
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
