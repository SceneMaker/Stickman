package de.dfki.stickmanSwing.animation.gesture;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class CoverMouth extends AnimationSwing {

    public CoverMouth(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int rotationUnit = 16;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftShoulder, "rotate", -rotationUnit * 3));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftUpperArm, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", rotationUnit * 9));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", rotationUnit * 9));
        playAnimationPart(200);

        pauseAnimation(1200);

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftShoulder, "rotate", +rotationUnit * 3));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftUpperArm, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftForeArm, "rotate", -rotationUnit * 9));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftHand, "rotate", -rotationUnit * 9));
        playAnimationPart(300);
    }
}
