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
 */
public class AngryStart extends AnimationSwing {

    public AngryStart(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        // angry start
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mFaceWrinkle, "shape", "ANGRY"));   ///Add by Robbie
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "shape", "ANGRY"));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "shape", "ANGRY"));
//		playAnimationPart(20);
        playAnimationPart(mDuration);
        pauseAnimation(10);
    }
}
