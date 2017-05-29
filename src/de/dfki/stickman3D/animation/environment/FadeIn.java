/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

import de.dfki.common.Gender;
import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.Animation3D;
import de.dfki.stickman3D.animationlogic.AnimationContent3D;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class FadeIn extends Animation3D {

    public FadeIn() {
        mAnimType = ANIMTYPE.ON;
    }

    public FadeIn(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    @Override
    public void playAnimation() {

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mStars, "shape", "STARSFADEIN"));
        playAnimationPart(500);

        pauseAnimation(500);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrow, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrow, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mNose, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEar, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEar, "shape", "FADEIN"));
        if(mStickmanFX.mType == Gender.TYPE.MALE)
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMaleHair, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mNeck, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mDownBody, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "shape", "FADEIN"));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mStars, "shape", "STARSFADEOUT"));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger1, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger2, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger3, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger1, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger2, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "shape", "FADEIN"));
        if(mStickmanFX.mType == Gender.TYPE.FEMALE)
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mFemaleHair, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperLeg, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeLeg, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFoot, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperLeg, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeLeg, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFoot, "shape", "FADEIN"));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
