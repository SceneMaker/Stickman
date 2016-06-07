/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.gesture;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import de.dfki.stickman.body.Body;
import de.dfki.stickman.body.FaceWrinkle;
import de.dfki.stickman.body.Head;
import de.dfki.stickman.body.LeftEye;
import de.dfki.stickman.body.LeftEyebrow;
import de.dfki.stickman.body.LeftForeArm;
import de.dfki.stickman.body.LeftHand;
import de.dfki.stickman.body.LeftLeg;
import de.dfki.stickman.body.LeftShoulder;
import de.dfki.stickman.body.LeftUpperArm;
import de.dfki.stickman.body.Mouth;
import de.dfki.stickman.body.Neck;
import de.dfki.stickman.body.RightEye;
import de.dfki.stickman.body.RightEyebrow;
import de.dfki.stickman.body.RightForeArm;
import de.dfki.stickman.body.RightHand;
import de.dfki.stickman.body.RightLeg;
import de.dfki.stickman.body.RightShoulder;
import de.dfki.stickman.body.RightUpperArm;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class FadeIn extends Animation
{
	private Stickman mStickman;
	public FadeIn(Stickman sm, int duration, boolean block)
	{	
		super(sm, duration, block);
		mStickman = sm;
	}

	// WaveLeft
	@Override
	public void playAnimation()
	{
		
		mStickman.starShowControler = true;
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mStarShow, "shape", "STARSFADE"));
		playAnimationPart(1000);	
		mStickman.starShowControler = false;
		
		mStickman.setCharacterInvisible = true;
		mStickman.fadeControler = false;
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightLeg, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftLeg, "shape", "DEFAULT"));
		mAnimationPart.add(new AnimationContent(mStickman.mNeck, "shape", "DEFAULT"));
//		mAnimationPart.add(new AnimationContent(mStickman.mLeftShoulder, "shape", "DEFAULT"));
//		mAnimationPart.add(new AnimationContent(mStickman.mRightShoulder, "shape", "DEFAULT"));
//		mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "shape", "DEFAULT"));
//		mAnimationPart.add(new AnimationContent(mStickman.mRightUpperArm, "shape", "DEFAULT"));	
//		mAnimationPart.add(new AnimationContent(mStickman.mRightLeg, "shape", "DEFAULT"));
//		mAnimationPart.add(new AnimationContent(mStickman.mRightShoulder, "shape", "DEFAULT"));	
		playAnimationPart(1000);	
		mStickman.setCharacterInvisible = false;
			
		// bring upper arm and fore arm in position
		int rotationUnit = 10;
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "rotate", rotationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationUnit * 16));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationUnit * 16));	
		playAnimationPart(200);
		pauseAnimation(100);

		// wave right
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit * 4));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", -rotationUnit * 4));
		playAnimationPart(100);

		// wave left
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationUnit * 4));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationUnit * 4));
		playAnimationPart(100);
		
		// wave right
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit * 4));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", -rotationUnit * 4));
		playAnimationPart(100);

		// wave left
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationUnit * 4));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationUnit * 4));
		playAnimationPart(100);
		pauseAnimation(200);
		
		// go back in the default position
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "rotate", -rotationUnit));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", -rotationUnit * 16));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", -rotationUnit * 16));
		playAnimationPart(20);
	}
}
