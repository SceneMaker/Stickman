/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.headfx;

import java.util.ArrayList;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.StickmanStageController;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class HeadDown extends AnimationFX {

	public HeadDown() {
		mAnimType = ANIMTYPE.ON;
	}

	public HeadDown(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", 15));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", 30));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "yrotate", 20));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOOKDOWN"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOOKDOWN"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", 20));
		playAnimationPart(mDuration);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", -35));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", -25));
		playAnimationPart(mDuration);

		pauseAnimation(500);

		// blink up
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "rotate", -15));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftUpperLegFX, "rotate", 5));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftFootFX, "yrotate", -20));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOOKDOWNEND"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOOKDOWNEND"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftForeLegFX, "rotate", 5));
		playAnimationPart(mDuration);

		if (StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);
	}
}
