/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.facefx;

import java.util.ArrayList;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;

/**
 *
 * @author Beka
 *
 */
public class Loved1 extends AnimationFX {

	// public Loved1() {
	// mAnimType = ANIMTYPE.ON;
	// }

	public Loved1(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// loved
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SMILE"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOVED1"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOVED1"));
		playAnimationPart(mDuration);

		pauseAnimation(10000);

		// no loved
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "shape", "SMILEEND"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "shape", "LOVEDEND"));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "shape", "LOVEDEND"));
		playAnimationPart(20);
	}
}
