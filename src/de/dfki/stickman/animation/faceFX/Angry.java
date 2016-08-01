/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.faceFX;

import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickman.animationlogicfx.Animation;
import de.dfki.stickman.animationlogicfx.AnimationContent;
import de.dfki.stickman.animationlogicfx.Animation.ANIMTYPE;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class.
 * The face moves from the default state to the angry state, and then comes back to the default state.
 * 
 * @author Patrick Gebhard
 */
public class Angry extends Animation {
/**
 * 
 * @param sm Stickman
 * @param duration Control the speed of the movement from one emotion state to another emotion state.
 * @param block block or not the others movements, when one movement is not finished.
 * 
 */
	public Angry() {
		mAnimType = ANIMTYPE.EmotionExpression;
	}
	
	public Angry(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}
	/**
	 * This method creates the angry facial movement.
	 */
	@Override
	public void playAnimation() {
		// angry
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "ANGRY"));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "ANGRY"));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRY"));
//		mAnimationPart.add(new AnimationContent(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRY"));   ///Add by Robbie
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "ANGRY"));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "ANGRY"));
		
//		System.out.println("test");
//		playAnimationPart(20);
		playAnimationPart(100);
//		System.out.println("test");
//		System.out.println("test");

		
		pauseAnimation(1200);

		// no angry
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "ANGRYEND"));
//		mAnimationPart.add(new AnimationContent(mStickmanFX.mFaceWrinkleFX, "shape", "ANGRYEND"));   ///Add by Robbie
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "ANGRYEND"));
		playAnimationPart(20);
	}
}
