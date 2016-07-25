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
public class Fear extends Animation {

//	mType ) ANIMTYPE.EmotionExpression;
	
	public Fear(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// fear
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "FEAR"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "SURPRISED"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "DISGUSTED"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "SURPRISED"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "DISGUSTED"));
		playAnimationPart(mDuration);

		pauseAnimation(1200);

		// no fear
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "FEAREND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "SURPRISEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "DISGUSTEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "SURPRISEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "DISGUSTEDEND"));
		playAnimationPart(20);
	}
}
