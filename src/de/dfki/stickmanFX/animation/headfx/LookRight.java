package de.dfki.stickmanFX.animation.headfx;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LookRight extends AnimationFX {

    public LookRight(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int translationUnit = 3;

        // look left
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOOKRIGHT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOOKRIGHT"));
        playAnimationPart(20);

//		// blink up
//		mAnimationPart = new ArrayList<>();
//		mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "DEFAULT"));
//		mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "DEFAULT"));
//		playAnimationPart(2);
    }
}
