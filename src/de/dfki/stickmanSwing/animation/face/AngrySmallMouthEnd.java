/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class AngrySmallMouthEnd extends AnimationSwing {

    public AngrySmallMouthEnd(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // angry with small mouth end
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "ANGRYSMALLMOUTHEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mFaceWrinkle, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "ANGRYEND"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "ANGRYEND"));
//		playAnimationPart(20);
        playAnimationPart(mDuration);

        pauseAnimation(10);
    }
}
