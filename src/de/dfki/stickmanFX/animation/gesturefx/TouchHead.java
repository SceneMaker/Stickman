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
public class TouchHead extends AnimationFX {

    public TouchHead() {
        mAnimType = ANIMTYPE.Gesture;
    }

    public TouchHead(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
    }

    @Override
    public void playAnimation() {
        int rotationUnit = 10;

        // bring Shoulder, upper arm and fore arm in position
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightShoulderFX, "rotate", rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", rotationUnit * 8));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", -rotationUnit * 14));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightHandFX, "rotate", -rotationUnit * 2));
        playAnimationPart(200);

        pauseAnimation(200);

        // wave hands
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightHandFX, "rotate", rotationUnit * 4));
        playAnimationPart(100);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightHandFX, "rotate", -rotationUnit * 4));
        playAnimationPart(100);
        pauseAnimation(200);

        // go back in the default position
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightShoulderFX, "rotate", -rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "rotate", -rotationUnit * 8));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "rotate", rotationUnit * 14)); //14
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightHandFX, "rotate", rotationUnit * 2));
        playAnimationPart(200);
    }
}
