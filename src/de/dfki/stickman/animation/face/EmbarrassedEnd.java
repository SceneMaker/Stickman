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
public class EmbarrassedEnd extends Animation {

	public EmbarrassedEnd(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		
		// embarrassed end
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "EMBARRASSEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "EMBARRASSEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "EMBARRASSEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "EMBARRASSEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "EMBARRASSEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "EMBARRASSEDEND"));
		playAnimationPart(mDuration);
		
		pauseAnimation(10);
	}
}
