/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.environmentfx;

import java.util.ArrayList;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanStageController;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX.ANIMTYPE;
import javafx.application.Platform;

/**
 *
 * @author Beka
 *
 */
public class FadeOut extends AnimationFX {

	public FadeOut() {
		mAnimType = ANIMTYPE.ON;
	}
	public FadeOut(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
		mStickmanFX = sm;
	}

	// WaveLeft
	@Override
	public void playAnimation() {
		
		mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mStarsFX, "shape", "STARSFADEIN"));
        playAnimationPart(500);
        
        pauseAnimation(500);
        
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mNeckFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mDownBody, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger1, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger2, "shape", "FADEOUT"));
        
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mStarsFX, "shape", "STARSFADEOUT"));
        
        
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger3, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger4, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger1, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger2, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger3, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "shape", "FADEOUT"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFootFX, "shape", "FADEOUT"));
        playAnimationPart(500);
        
		StickmanStageController.currentRadioButton.setSelected(false);
	}
}
