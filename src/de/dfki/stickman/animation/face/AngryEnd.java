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
 *An angry facial movement is created in this class.
 *The face moves from the angry state to the default state, and stays in the default state until it receives a new command.
 *
 * @author Patrick Gebhard
 *
 */
public class AngryEnd extends Animation {
	/**
	 * @param sm Stickman
	 * @param duration Control the speed of the movement from one emotion state to another emotion state.
	 * @param block block or not the others movements, when one movement is not finished.
	 */
	public AngryEnd(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}
	
	/**
	 * This method creates the angry facial movement.
	 */
	@Override
	public void playAnimation() {
		// angry end
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "ANGRYEND"));
//		playAnimationPart(20);
		playAnimationPart(mDuration);
		
		pauseAnimation(10);

	}
}
