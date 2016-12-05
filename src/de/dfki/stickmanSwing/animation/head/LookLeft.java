package de.dfki.stickmanSwing.animation.head;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationContentSwing;
import de.dfki.stickmanSwing.animationlogic.AnimationSwing;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LookLeft extends AnimationSwing {

    public LookLeft(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int translationUnit = 3;

        // look left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "LOOKLEFT"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "LOOKLEFT"));
        playAnimationPart(20);

//		// blink up
//		mAnimationPart = new ArrayList<>();
//		mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "DEFAULT"));
//		mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "DEFAULT"));
//		playAnimationPart(2);
    }
}
