/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.face;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Embarrassed extends Animation {

	public Embarrassed() {
		mAnimType = ANIMTYPE.EmotionExpression;
	}

	public Embarrassed(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {

		// embarrassed
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "EMBARRASSED"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "EMBARRASSED"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "EMBARRASSED"));
		mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "EMBARRASSED")); /// Add
																									/// by
																									/// Robbie
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "EMBARRASSED"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "EMBARRASSED"));
		playAnimationPart(mDuration);
		// playAnimationPart(20);

		pauseAnimation(1200);

		// no embarrassed
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "EMBARRASSEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "EMBARRASSEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "EMBARRASSEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "EMBARRASSEDEND")); /// Add
																										/// by
																										/// Robbie
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "EMBARRASSEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "EMBARRASSEDEND"));
		playAnimationPart(20);
	}
}
