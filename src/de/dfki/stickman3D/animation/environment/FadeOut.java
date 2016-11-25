/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.environment;

import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;
import de.dfki.stickman3D.animationlogic.Animation.ANIMTYPE;
import javafx.application.Platform;

/**
 *
 * @author Beka
 *
 */
public class FadeOut extends Animation {

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
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mStarsFX, "shape", "STARSFADEIN"));
		playAnimationPart(500);

		pauseAnimation(500);

		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mNoseFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMaleHairFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mNeckFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mUpperBody, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mDownBody, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperArmFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeArmFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger1, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger2, "shape", "FADEOUT"));

		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mStarsFX, "shape", "STARSFADEOUT"));

		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger3, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFinger4, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperArmFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeArmFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightWrist, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger1, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger2, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger3, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFinger4, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mFemaleHairFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftUpperLegFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftForeLegFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftFootFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightUpperLegFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightForeLegFX, "shape", "FADEOUT"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightFootFX, "shape", "FADEOUT"));
		playAnimationPart(500);

		StickmanStageController.currentRadioButton.setSelected(false);
	}
}
