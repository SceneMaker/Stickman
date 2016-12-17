/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

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
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mStarsFX, "shape", "STARSFADEIN"));
        playAnimationPart(500);

        pauseAnimation(500);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrowFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyeFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouthFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrowFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyeFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mNoseFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEar, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEar, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMaleHairFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mNeckFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mDownBody, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "shape", "FADEIN"));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mStarsFX, "shape", "STARSFADEOUT"));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger1, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger2, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger3, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger1, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger2, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mFemaleHairFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperLegFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeLegFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFootFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperLegFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeLegFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFootFX, "shape", "FADEIN"));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
