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
public class ContemptStart extends Animation {

	public ContemptStart(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// Contempt start
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "CONTEMPT"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "CONTEMPT"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "CONTEMPT"));
		playAnimationPart(mDuration);

		pauseAnimation(10);
	}
}
