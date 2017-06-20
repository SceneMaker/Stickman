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
public class FadeOut extends Animation3D {

    public FadeOut() {
        mAnimType = ANIMTYPE.ON;
    }

    public FadeOut(Stickman3D sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    // WaveLeft
    @Override
    public void playAnimation() {

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mStars, "shape", "STARSFADEIN"));
        playAnimationPart(500);

        pauseAnimation(500);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrow, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEye, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouth, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mNose, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEar, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEar, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrow, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEye, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHead, "shape", "FADEOUT"));
        if(mStickmanFX.mType == Gender.TYPE.MALE)
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMaleHair, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mNeck, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mDownBody, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArm, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArm, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger1, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger2, "shape", "FADEOUT"));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mStars, "shape", "STARSFADEOUT"));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger3, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArm, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArm, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger1, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger2, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "shape", "FADEOUT"));
        if(mStickmanFX.mType == Gender.TYPE.FEMALE)
            mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mFemaleHair, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperLeg, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeLeg, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFoot, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperLeg, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeLeg, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFoot, "shape", "FADEOUT"));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
