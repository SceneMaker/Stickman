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
public class SurprisedEnd extends Animation {

	public SurprisedEnd(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		
		// surprised end
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "SURPRISEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "SURPRISEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "SURPRISEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "SURPRISEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "SURPRISEDEND"));
		playAnimationPart(mDuration);
		
		pauseAnimation(10);
	}
}
