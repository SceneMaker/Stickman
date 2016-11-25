/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;
import de.dfki.stickman3D.animationlogic.Animation.ANIMTYPE;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class FadeIn extends Animation {

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
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mStarsFX, "shape", "STARSFADEIN"));
		playAnimationPart(500);

		pauseAnimation(500);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mNoseFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMaleHairFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mNeckFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mUpperBody, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mDownBody, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "shape", "FADEIN"));

		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mStarsFX, "shape", "STARSFADEOUT"));

		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger1, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger2, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger3, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger4, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger1, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger2, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger3, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger4, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperLegFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeLegFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFootFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperLegFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeLegFX, "shape", "FADEIN"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFootFX, "shape", "FADEIN"));
		playAnimationPart(500);
		StickmanStageController.currentRadioButton.setSelected(false);
	}
}
