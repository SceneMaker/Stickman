/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.faceFX;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class EmbarrassedStart extends Animation {

	public EmbarrassedStart(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		
		// embarrassed start
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "EMBARRASSED"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "EMBARRASSED"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "EMBARRASSED"));
		mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "EMBARRASSED"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "EMBARRASSED"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "EMBARRASSED"));
		playAnimationPart(mDuration);
		
		pauseAnimation(10);
	}
}
