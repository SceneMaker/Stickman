/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class WaveRight extends AnimationSwing {

    public WaveRight(StickmanSwing sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int rotationUnit = 10;

        // 50 is the sum of all animation parts
        float timeFactor = (mDuration > 0) ? mDuration / 50 : 1;

        // bring upper arm and fore arm in position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightUpperArm, "rotate", -rotationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightForeArm, "rotate", -rotationUnit * 16));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightHand, "rotate", -rotationUnit * 16));
        playAnimationPart(200);

        pauseAnimation(200);

        // wave right
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightForeArm, "rotate", rotationUnit * 4));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightHand, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightForeArm, "rotate", -rotationUnit * 4));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightHand, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        pauseAnimation(200);

        // go back in the default position
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightUpperArm, "rotate", rotationUnit));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightForeArm, "rotate", rotationUnit * 16));
        mAnimationPart.add(new AnimationContentSwing(mStickman.mRightHand, "rotate", rotationUnit * 16));
        playAnimationPart(200);
    }
}
