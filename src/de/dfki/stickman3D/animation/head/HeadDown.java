/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class HeadDown extends Animation {

	public HeadDown() {
		mAnimType = ANIMTYPE.ON;
	}

	public HeadDown(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "rotate", 15));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperLegFX, "rotate", 30));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFootFX, "yrotate", 20));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "LOOKDOWN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "LOOKDOWN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeLegFX, "rotate", 20));
		playAnimationPart(mDuration);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperLegFX, "rotate", -35));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeLegFX, "rotate", -25));
		playAnimationPart(mDuration);

		pauseAnimation(500);

		// blink up
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "rotate", -15));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperLegFX, "rotate", 5));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFootFX, "yrotate", -20));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "LOOKDOWNEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "LOOKDOWNEND"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeLegFX, "rotate", 5));
		playAnimationPart(mDuration);

		if (StickmanStageController.currentRadioButton != null)
			StickmanStageController.currentRadioButton.setSelected(false);
	}
}
