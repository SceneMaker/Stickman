/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.head;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class HeadShake extends Animation
{

	public HeadShake(Stickman sm, int duration, boolean block)
	{
		super(sm, duration, block);
	}

	@Override
	public void playAnimation()
	{
		int rotationUnit = 6;
		
		// Its action is strange for the first time!		
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "rotate", -rotationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "rotate", -rotationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "rotate", -rotationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "rotate", -rotationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mHead, "rotate", -rotationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "rotate", -rotationUnit));

		playAnimationPart(200);
		pauseAnimation(100);	
		
		mStickman.mRightEye.setDefaulRotation(0);
		mStickman.mRightEyebrow.setDefaulRotation(0);
		mStickman.mLeftEye.setDefaulRotation(0);
		mStickman.mLeftEyebrow.setDefaulRotation(0);
		mStickman.mHead.setDefaulRotation(0);
		mStickman.mMouth.setDefaulRotation(0);
		
		// shaking head 5 times from Robbie
		for (int i = 0; i < 3; i++)
		{
			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "rotate", rotationUnit * 2));
			mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "rotate", rotationUnit * 2));
			mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "rotate", rotationUnit * 2));
			mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "rotate", rotationUnit * 2));
			mAnimationPart.add(new AnimationContent(mStickman.mHead, "rotate", rotationUnit * 2));
			mAnimationPart.add(new AnimationContent(mStickman.mMouth, "rotate", rotationUnit * 2));
			
			
			playAnimationPart(200);
			pauseAnimation(100);
			
			mStickman.mRightEye.setDefaulRotation(0);
			mStickman.mRightEyebrow.setDefaulRotation(0);
			mStickman.mLeftEye.setDefaulRotation(0);
			mStickman.mLeftEyebrow.setDefaulRotation(0);
			mStickman.mHead.setDefaulRotation(0);
			mStickman.mMouth.setDefaulRotation(0);
			
			mAnimationPart = new ArrayList<>();
			mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "rotate", -rotationUnit * 2));
			mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "rotate", -rotationUnit * 2));
			mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "rotate", -rotationUnit * 2));
			mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "rotate", -rotationUnit * 2));
			mAnimationPart.add(new AnimationContent(mStickman.mHead, "rotate", -rotationUnit * 2));
			mAnimationPart.add(new AnimationContent(mStickman.mMouth, "rotate", -rotationUnit * 2));
			
			playAnimationPart(200);
			pauseAnimation(100);
			
			mStickman.mRightEye.setDefaulRotation(0);
			mStickman.mRightEyebrow.setDefaulRotation(0);
			mStickman.mLeftEye.setDefaulRotation(0);
			mStickman.mLeftEyebrow.setDefaulRotation(0);
			mStickman.mHead.setDefaulRotation(0);
			mStickman.mMouth.setDefaulRotation(0);
			
		}

		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "rotate", 1));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "rotate", 1));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "rotate", 1));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "rotate", 1));
		mAnimationPart.add(new AnimationContent(mStickman.mHead, "rotate", 1));
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "rotate", 1));

		playAnimationPart(200);
		pauseAnimation(100);
		
	}

}
