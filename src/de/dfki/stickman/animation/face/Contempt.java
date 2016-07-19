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
public class Contempt extends Animation {

	public Contempt(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// Contempt
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "CONTEMPT"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "CONTEMPT"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "CONTEMPT"));
		playAnimationPart(mDuration);

		pauseAnimation(1200);

		// no Contempt
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "CONTEMPTEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "CONTEMPTEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "CONTEMPTEND"));
		playAnimationPart(20);
	}
}
