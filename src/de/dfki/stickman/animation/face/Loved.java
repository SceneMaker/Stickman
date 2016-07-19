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
public class Loved extends Animation {

	public Loved(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// loved
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "SMILE"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "LOVED"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "LOVED"));
		playAnimationPart(mDuration);

		pauseAnimation(1200);

		// no loved
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "SMILEEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "LOVEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "LOVEDEND"));
		playAnimationPart(20);
	}
}
