/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.face;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import de.dfki.stickman.body.LeftEyebrow;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class AngrySmallMouth extends Animation {
	public AngrySmallMouth(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// angry
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "ANGRYSMALLMOUTH"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "ANGRY"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "ANGRY"));
		mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "ANGRY"));   ///Add by Robbie
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "ANGRY"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "ANGRY"));
//		playAnimationPart(20);
		playAnimationPart(mDuration);
		
		pauseAnimation(1200);

		// no angry
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "ANGRYSMALLMOUTHEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "ANGRYEND"));   ///Add by Robbie
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "ANGRYEND"));
		playAnimationPart(2000);
	}
}
