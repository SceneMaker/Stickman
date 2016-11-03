/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.environmentfx;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanStageController;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX.ANIMTYPE;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class FadeIn extends AnimationFX {

	public FadeIn() {
		mAnimType = ANIMTYPE.ON;
	}
	
    public FadeIn(StickmanFX sm, int duration, boolean block) {
        super(sm, duration, block);
        mStickmanFX = sm;
    }

    @Override
    public void playAnimation() {
    	
    	mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mStarsFX, "shape", "STARSFADEIN"));
        playAnimationPart(500);
        
        pauseAnimation(500);
        
    	mAnimationPartFX = new ArrayList<>();
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mNoseFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mNeckFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mUpperBody, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mDownBody, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperArmFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeArmFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftWrist, "shape", "FADEIN"));
        
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mStarsFX, "shape", "STARSFADEOUT"));
        
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger1, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger2, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger3, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFinger4, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperArmFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeArmFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightWrist, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger1, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger2, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger3, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFinger4, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightUpperLegFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightForeLegFX, "shape", "FADEIN"));
        mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightFootFX, "shape", "FADEIN"));
        playAnimationPart(500);
		StickmanStageController.currentRadioButton.setSelected(false);
    }
}
