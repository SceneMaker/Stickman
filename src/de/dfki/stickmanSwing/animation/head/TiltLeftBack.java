/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanSwing.animation.head;

import de.dfki.stickmanSwing.StickmanSwing;
import de.dfki.stickmanSwing.animationlogic.Animation;
import de.dfki.stickmanSwing.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class TiltLeftBack extends Animation {

	public TiltLeftBack(StickmanSwing sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		int translationUnit = 8;

		// head down
		mAnimationPart = new ArrayList<>();
		// which bodyparts are involved - check dependencies
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "tilt", -translationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "tilt", -translationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "tilt", -translationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "tilt", -translationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mHead, "tilt", -translationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "tilt", -translationUnit));

		playAnimationPart(200);
	}
}
