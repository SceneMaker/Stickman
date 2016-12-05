/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanFX.animation.headfx;

import java.util.ArrayList;

import de.dfki.common.Gender;
import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanFX.StickmanFX;
import de.dfki.stickmanFX.animationlogic.AnimationContentFX;
import de.dfki.stickmanFX.animationlogic.AnimationFX;

/**
 *
 * @author Beka
 *
 */
public class HeadShake extends AnimationFX {

    StickmanFX mStickmanFX;

    public HeadShake(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        this.mStickmanFX = sm;
    }

    @Override
    public void playAnimation() {
        int rotationUnit = 10;

        // Its action is strange for the first time!
        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "rotate", -rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "rotate", -rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "rotate", -rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "rotate", -rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", -rotationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "rotate", -rotationUnit));
        } else {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "rotate", -rotationUnit));
        }

        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "rotate", -rotationUnit));
        playAnimationPart(200);
        pauseAnimation(100);

        // shaking head 5 times from Robbie
        for (int i = 0; i < 3; i++) {
            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "rotate", rotationUnit * 2));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "rotate", rotationUnit * 2));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "rotate", rotationUnit * 2));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "rotate", rotationUnit * 2));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", rotationUnit * 2));

            if (mStickmanFX.mType == Gender.TYPE.MALE) {
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "rotate", rotationUnit * 2));
            } else {
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "rotate", rotationUnit * 2));
            }

            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "rotate", rotationUnit * 2));
            playAnimationPart(200);
            pauseAnimation(100);

            mAnimationPartFX = new ArrayList<>();
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "rotate", -rotationUnit * 2));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "rotate", -rotationUnit * 2));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "rotate", -rotationUnit * 2));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "rotate", -rotationUnit * 2));
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", -rotationUnit * 2));

            if (mStickmanFX.mType == Gender.TYPE.MALE) {
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "rotate", -rotationUnit * 2));
            } else {
                mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "rotate", -rotationUnit * 2));
            }

            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "rotate", -rotationUnit * 2));
            playAnimationPart(200);
            pauseAnimation(100);
        }

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "rotate", rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "rotate", rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "rotate", rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "rotate", rotationUnit));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", rotationUnit));

        if (mStickmanFX.mType == Gender.TYPE.MALE) {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "rotate", rotationUnit));
        } else {
            mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "rotate", rotationUnit));
        }

        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "rotate", rotationUnit));

        playAnimationPart(200);
        pauseAnimation(100);

    }

}
