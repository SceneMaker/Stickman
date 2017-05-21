/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.gesturefx;

import java.util.ArrayList;

import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;

/**
 *
 * @author Beka
 *
 */
public class WaveRight extends AnimationFX {

    public WaveRight() {
        mAnimType = ANIMTYPE.Gesture;
    }

    public WaveRight(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int rotationUnit = 10;

        // 50 is the sum of all animation parts
        float timeFactor = (mDuration > 0) ? mDuration / 50 : 1;

        // bring upper arm and fore arm in position
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", -rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", -rotationUnit * 16));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightHandFX, "rotate", -rotationUnit * 16));
        playAnimationPart(200);

        pauseAnimation(200);

        // wave right
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", rotationUnit * 4));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        // wave left
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", -rotationUnit * 4));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        pauseAnimation(200);

        // go back in the default position
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", rotationUnit * 16));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightHandFX, "rotate", rotationUnit * 16));
        playAnimationPart(200);
    }
}
