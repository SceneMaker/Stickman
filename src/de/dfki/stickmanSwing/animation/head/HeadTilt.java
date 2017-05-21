/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class HeadTilt extends AnimationSwing {

    public HeadTilt(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int translationUnit = 8;

        // head down
        mAnimationPart = new ArrayList<>();
        // which bodyparts are involved - check dependencies
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mHead, "tilt", translationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "tilt", translationUnit));

        playAnimationPart(150);

        pauseAnimation(200);

        mAnimationPart = new ArrayList<>();
        // which bodyparts are involved - check dependencies
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEye, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightEyebrow, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEye, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mLeftEyebrow, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mHead, "tilt", -translationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mMouth, "tilt", -translationUnit));

        playAnimationPart(150);
    }
}
