/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.face;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.Animation;
import de.dfki.stickmanSwing.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class AngrySmallMouthStart extends Animation {

	public AngrySmallMouthStart(StickmanSwing sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// angry with small mouth start
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "ANGRYSMALLMOUTH"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "ANGRY"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "ANGRY"));
		mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "ANGRY"));   ///Add by Robbie
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "ANGRY"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "ANGRY"));
//		playAnimationPart(20);
		playAnimationPart(mDuration);
		
		pauseAnimation(10);
	}
}
