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
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mStarsFX, "shape", "STARSFADEIN"));
        playAnimationPart(500);

        pauseAnimation(500);

        mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyebrowFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEyeFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMouthFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mNoseFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftEar, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEar, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyebrowFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightEyeFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mHeadFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mMaleHairFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mNeckFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mUpperBody, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mDownBody, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperArmFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeArmFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftWrist, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger1, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger2, "shape", "FADEOUT"));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mStarsFX, "shape", "STARSFADEOUT"));

        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger3, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFinger4, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperArmFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeArmFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightWrist, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger1, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger2, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger3, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFinger4, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mFemaleHairFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftUpperLegFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftForeLegFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mLeftFootFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightUpperLegFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightForeLegFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContent3D(mStickmanFX.mRightFootFX, "shape", "FADEOUT"));
        playAnimationPart(500);

        if (StickmanStageController.currentRadioButton != null) {
            StickmanStageController.currentRadioButton.setSelected(false);
        }
    }
}
